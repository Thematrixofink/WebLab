package com.weblab.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.weblab.system.entity.Admin;
import com.weblab.system.entity.Users;
import com.weblab.system.entity.vo.LoginUserVo;
import com.weblab.system.mapper.AdminMapper;
import com.weblab.system.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author inkslab
 * @since 2023-04-12
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Map<String, Object> AdminLogin(LoginUserVo adminVo) {
        List<LoginUserVo> login = adminMapper.adLogin(adminVo);
        if(login.size() >0){
            String key = "admin:"+UUID.randomUUID();
            Map<String, Object> data = new HashMap<>();
            data.put("token",key);
            return data;
        }
        return null;
    }

    @Override
    public String setPassword(Admin admin) {
        LambdaUpdateWrapper<Admin> updateWrapper = new UpdateWrapper<Admin>().lambda();
        updateWrapper.eq(Admin::getName,admin.getName());
        updateWrapper.set(Admin::getPassword,admin.getPassword());

        int update = adminMapper.update(null, updateWrapper);
        if(update == 1){
            return "修改成功";
        }

        return null;
    }

    @Override
    public List<Users> getUsers(){
        List<Users> data = adminMapper.getUsers();

        if(data.size() > 0){
            return data;
        }

        return null;
    }
}
