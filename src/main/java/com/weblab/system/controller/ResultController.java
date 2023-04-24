package com.weblab.system.controller;

import com.weblab.system.entity.Score;
import com.weblab.system.service.IResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.weblab.common.vo.*;

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
@RequestMapping("/result")
public class ResultController {
    @Autowired
    private IResultService resultService;

    //保存成绩
    @PostMapping("/saveResult")
    public Result<Score> saveResult(@RequestBody Score result){
        Score data = resultService.saveResult(result);
        if(data == null){
            return Result.fail(20010,"保存失败");
        }
        return Result.success(data);
    }

    //提交成绩
    @PostMapping("/setResult")
    public Result<Score> setResult(@RequestParam("groupId") Integer groupId,@RequestParam("judgesName")String judgeName){
        Score data = resultService.setResult(groupId,judgeName);
        if(data == null){
            return Result.fail(20009,"修改失败");
        }else {
            return Result.success(data);
        }
    }


}
