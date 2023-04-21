package com.weblab.system.controller;

import com.weblab.common.vo.returnResult;
import com.weblab.system.entity.Result;
import com.weblab.system.entity.vo.LoginUserVo;
import com.weblab.system.service.IUrlService;
import com.weblab.system.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private IUrlService urlService;

    @PostMapping("/login")
    public returnResult<Map<String,Object>> usersLogin(@RequestBody LoginUserVo userVo){
        Map<String, Object> data = usersService.UsersLogin(userVo);
        if(data!=null) {
            return returnResult.success(data);
        }
        return returnResult.fail(20002,"用户名或密码错误!");
    }

    @PostMapping("/setPassword")
    public returnResult<Map<String,Object>> changePassword(@RequestBody LoginUserVo userVo){
        Map<String,Object> data = usersService.setPassword(userVo);
        if(data==null){
            return returnResult.fail(20003,"此用户不存在！!");
        }
        return returnResult.success("修改成功!");
    }

    @GetMapping("/student/score")
    public returnResult<Map<String,Object>> lookScore(@RequestParam("groupId") Integer groupId){
        Map<String,Object> data = usersService.getScore(groupId);
        if(data == null){
            return returnResult.fail(20004,"没有查询到此小组成绩！");
        }else{
            return returnResult.success(data);
        }
    }

    @GetMapping("/judge/getUrl")
    public returnResult<Map<String,Object>> lookVideo(){
        Map<String,Object> data = urlService.getAll();
        if(data == null){
            return returnResult.fail("未查询到任何小组！");
        }
        return returnResult.success(data);
    }



}
