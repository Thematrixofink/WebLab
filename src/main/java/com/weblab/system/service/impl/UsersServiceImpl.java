package com.weblab.system.service.impl;

import com.weblab.system.entity.Users;
import com.weblab.system.mapper.UsersMapper;
import com.weblab.system.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author inkslab
 * @since 2023-04-12
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {
    @Autowired
    IUsersService usersService;
    public Map<String, Object> UsersLogin(Users users) {
        return null;
    }
}
