package com.weblab.system.controller;

import com.weblab.common.vo.Result;
import com.weblab.system.entity.Admin;
import com.weblab.system.entity.Score;
import com.weblab.system.entity.Url;
import com.weblab.system.entity.Users;
import com.weblab.system.entity.vo.LoginUserVo;
import com.weblab.system.service.IAdminService;
import com.weblab.system.service.IResultService;
import com.weblab.system.service.IUrlService;
import com.weblab.system.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import java.util.HashMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;
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
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private IAdminService adminService;
    @Autowired
    private IResultService resultService;
    @Autowired
    private IUsersService usersService;
    @Autowired
    private IUrlService urlService;

    // 登录
    @PostMapping("/login")
    public Result<Map<String,Object>> adminLogin(@Validated @RequestBody LoginUserVo user){
        Map<String, Object> data = adminService.AdminLogin(user);
        if(data!=null) {
            return Result.success(data);
        }
        return Result.fail(20002,"用户名或密码错误!");
    }

    // 修改密码
    @PutMapping("/changePassword")
    public Result<Map<String,Object>> changePassword(@RequestBody Admin admin){
        String data = adminService.setPassword(admin);

        if(data==null){
            return Result.fail(20003,"此用户不存在！!");
        }

        return Result.success(data);
    }

    // 获取所有用户
    @GetMapping("/users")
    public Result<List<Users>> getUsers(){
        List<Users> data = adminService.getUsers();

        if(data == null){
            return Result.fail(20004,"没有查询到用户！");
        }

        return Result.success(data,"查询成功");
    }

    // 根据用户名获取用户
    @GetMapping("/users/{username}")
    public Result<Users> getUser(@PathVariable("username") String username){
        Users data = adminService.getUser(username);

        if(data == null){
            return Result.fail(20012,"没有查询到用户！");

        }

        return Result.success(data,"查询成功");
    }

    // 重置用户密码
    @PutMapping("/users/reset/{username}")
    public Result<String> resetPassword(@PathVariable("username") String username){
        String data = adminService.resetPassword(username);
        if(data == null){
            return Result.fail(20011,"没有查询到用户！");
        }
        return Result.success(data);
    }

    //查看评委所有的评分
    @GetMapping("/getAllScore")
    public Result<List<Score>> getAllScore(){
        List<Score> data = resultService.getAllScore();
        if(data == null){
            return Result.fail(20012,"没有查询到打分");
        }
        return Result.success(data);
    }
    //撤销评委打分提交状态至可修改状态
    @PostMapping("/judges/changeStatus")
    public Result<Map<String,Object>> changeStatus(@RequestParam("groupId")String groupId,@RequestParam("judgeName")String judgeName){
        Map<String,Object> data = resultService.changeStatus(groupId,judgeName);
        if(data == null){
            return Result.fail(20013,"更改失败");
        }
        return Result.success(data);
    }

    //为学生分组
    @PostMapping("/users/setGroup")
    public Result<Map<String,Object>> setGroup(@RequestParam("username")String username,@RequestParam("groupId")Integer groupId){
        Map<String,Object> data = usersService.setGroup(username,groupId);
        if(data == null){
            return Result.fail(20014,"设置组号失败");
        }
        return Result.success(data);
    }

    //设置视频url和项目url
    @PostMapping("/setUrl")
    public Result<Map<String,Object>> setUrl(@RequestParam("groupId")Integer groupId,@RequestParam("videoUrl")String videoUrl,@RequestParam("projectUrl")String projectUrl){
        Map<String,Object> data = urlService.setUrl(groupId,videoUrl,projectUrl);
        if(data == null){
            return Result.fail(20015,"设置url失败");
        }
        return Result.success(data);
    }

    //获得所有组的url地址
    @GetMapping("/getUrl")
    public Result<List<Url>> getUrl(){
        List<Url> data = urlService.getAll();
        if(data == null){
            return Result.fail(20016,"获取所有的url失败");
        }
        return Result.success(data);
    }

    //更改某组的视频url和项目url
    @PostMapping("/changeUrl")
    public Result<Map<String,Object>> changeUrl(@RequestParam("groupId")Integer groupId,@RequestParam("videoUrl")String videoUrl,@RequestParam("projectUrl")String projectUrl){
        Map<String,Object> data = urlService.changeUrl(groupId,videoUrl,projectUrl);
        if(data == null){
            return Result.fail(20017,"更改url失败");
        }
        return Result.success(data);
    }
    @PutMapping("/users/{username}")
    public Result<String> resetPassword(@PathVariable("username") String username){
        String data = adminService.resetPassword(username);

        if(data == null){
            return Result.fail(20004,"没有查询到用户！");
        }

        return Result.success(data);
    }

}
