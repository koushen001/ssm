package com.cike.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cike.entity.User;
import com.cike.mapper.UserMapper;
import com.cike.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cike
 * @since 2017-09-02
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
