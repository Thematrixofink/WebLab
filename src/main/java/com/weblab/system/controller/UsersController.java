package com.weblab.system.controller;

import com.weblab.common.vo.Result;
import com.weblab.system.entity.vo.LoginUserVo;
import com.weblab.system.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author inkslab
 * @since 2023-04-12
 */
@RestController
//访问地址的前缀
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private IUsersService usersService;

    @PostMapping("/login")
    public Result<Map<String,Object>> usersLogin(@RequestBody LoginUserVo userVo){
        Map<String, Object> data = usersService.UsersLogin(userVo);
        if(data!=null) {
            return Result.success(data);
        }
        return Result.fail(20002,"用户名或密码错误!");
    }
}
