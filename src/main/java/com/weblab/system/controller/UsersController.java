package com.weblab.system.controller;

import com.weblab.common.vo.Result;
import com.weblab.system.entity.Score;
import com.weblab.system.entity.Url;
import com.weblab.system.entity.Users;
import com.weblab.system.entity.vo.LoginUserVo;
import com.weblab.system.service.IResultService;
import com.weblab.system.service.IUrlService;
import com.weblab.system.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private IUsersService usersService;
    @Autowired
    private IUrlService urlService;
    @Autowired
    private IResultService resultService;

    //用户登录
    @PostMapping("/login")
    public Result<Users> usersLogin(@RequestBody LoginUserVo userVo){
        Users data = usersService.UsersLogin(userVo);
        if(data!=null) {
            return Result.success(data);
        }
        return Result.fail(20002,"用户名或密码错误!");
    }

    //修改密码
    @PostMapping("/setPassword")
    public Result<Users> changePassword(@RequestBody LoginUserVo userVo){
        Users data = usersService.setPassword(userVo);
        if(data==null){
            return Result.fail(20003,"此用户不存在！!");
        }
        return Result.success(data,"success");
    }

    //学生查看成绩
    @GetMapping("/student/score")
    public Result<Map<String,Object>> lookScore(@RequestParam("groupId") Integer groupId){
        Map<String,Object> data = usersService.getScore(groupId);
        if(data == null){
            return Result.fail(20004,"没有查询到此小组成绩！");
        }else{
            return Result.success(data);
        }
    }

    //评委获得所有小组的url
    @GetMapping("/judge/getUrl")
    public Result<List<Url>> lookVideo(){
        List<Url> data = urlService.getAll();
        if(data == null){
            return Result.fail(20005,"未查询到任何小组！");
        }
        return Result.success(data);
    }

    //修改未提交的表
    @PostMapping("/judge/changeScore")
    public Result<Map<String,Object>> changeScore(@RequestBody Score score){
        Map<String,Object> data = resultService.updateSocre(score);
        if(data == null){
            return  Result.fail(20006,"修改失败！");
        }else{
             return Result.success(data);
        }
    }

    //获取当前评委未提交的表的信息
    @GetMapping("/judge/getUnSubmitScore")
    public Result<List<Score>> getNoSubmitScore(@RequestParam("judgesName") String judgeName){
        List<Score> data = resultService.getNosubmit(judgeName);
        if(data == null){
            return Result.fail(20007,"当前评委没有为提交的打分");
        }else{
            return Result.success(data);
        }
    }

    //获取当前评委所有打分的表
    @GetMapping("/judge/getAll")
    public Result<List<Score>> getAllScore(@RequestParam("judgesName") String judgeName){
        List<Score> data = resultService.getAllScore(judgeName);
        if(data == null){
            return Result.fail(20008,"没有查询到此评委的打分记录");
        }else{
            return Result.success(data);
        }
    }
}
