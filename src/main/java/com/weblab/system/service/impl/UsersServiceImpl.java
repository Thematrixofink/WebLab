package com.weblab.system.service.impl;

import com.weblab.system.entity.Users;
import com.weblab.system.entity.vo.LoginUserVo;
import com.weblab.system.mapper.UsersMapper;
import com.weblab.system.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
    private UsersMapper usersMapper;

    @Override
    public Map<String, Object> UsersLogin(LoginUserVo userVo) {
        List<LoginUserVo> login = usersMapper.usLogin(userVo);
        if(login.size()>0){
            String key = "user:"+ UUID.randomUUID();
            Map<String, Object> data = new HashMap<>();
            data.put("token",key);
            return data;
        }
        return null;
    }
}
