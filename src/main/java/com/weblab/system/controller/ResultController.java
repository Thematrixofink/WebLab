package com.weblab.system.controller;

import com.weblab.system.entity.Result;
import com.weblab.system.service.IResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.weblab.common.vo.*;
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
@RequestMapping("/result")
public class ResultController {
    @Autowired
    private IResultService resultService;

    @PostMapping("/setResult")
    public returnResult<Map<String,Object>> setResult(@RequestBody Result result){
        Map<String,Object> data = resultService.setResult(result);
        if(data == null){
            return returnResult.fail("你已经对改组进行过打分！请勿再次评分");
        }
        return returnResult.success(data);
    }

}
