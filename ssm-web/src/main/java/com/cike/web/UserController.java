package com.cike.web;


import com.cike.common.ServerResponse;
import com.cike.entity.User;
import com.cike.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 用户管理
 * </p>
 *
 * @author cike
 * @since 2017-09-02
 */
@Api(value = "用户管理")
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "查询用户", httpMethod = "GET")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse list() {
        return ServerResponse.createBySuccess(userService.selectList(null));
    }

    @ApiOperation(value = "添加或修改用户", httpMethod = "POST")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse save(User user) {
        boolean b = userService.insertOrUpdate(user);
        if (b) {
            return ServerResponse.createBySuccessMessage("操作成功");
        }
        return ServerResponse.createByErrorMessage("操作失败");
    }

    @ApiOperation(value = "删除用户", httpMethod = "GET")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse delete(@PathVariable Integer id) {
        boolean b = userService.deleteById(id);
        if (b) {
            return ServerResponse.createBySuccessMessage("操作成功");
        }
        return ServerResponse.createByErrorMessage("操作失败");
    }

}
