package com.weblab.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.weblab.system.entity.Admin;
import com.weblab.system.entity.vo.LoginUserVo;
import com.weblab.system.service.IAdminService;
import com.weblab.system.service.IUsersService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Resource
    IUsersService usersService;
    @Resource
    IAdminService adminService;

    @PostMapping("/login")
    public String login(
            LoginUserVo loginUserVo,
            Model model,
            HttpSession session) {

        // 具体登陆业务
        // 1. 判断身份
        // 2. 根据身份查询数据库
        if(loginUserVo.getIdentity().equals("admin")){

        }
        else if(loginUserVo.getIdentity().equals("student")){

        }

        return null;
    }

}
