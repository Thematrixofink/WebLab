package com.weblab.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.weblab.system.entity.Admin;
import com.weblab.system.entity.vo.LoginUserVo;
import com.weblab.system.mapper.AdminMapper;
import com.weblab.system.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
