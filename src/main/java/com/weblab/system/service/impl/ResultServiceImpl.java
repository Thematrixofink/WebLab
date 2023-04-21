package com.weblab.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.weblab.system.entity.Score;
import com.weblab.system.mapper.ResultMapper;
import com.weblab.system.service.IResultService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author inkslab
 * @since 2023-04-12
 */
@Service
public class ResultServiceImpl extends ServiceImpl<ResultMapper, Score> implements IResultService {
    @Autowired
    private ResultMapper resultMapper;

    @Override
    public Map<String, Object> setResult(Score result) {
        QueryWrapper<Score> wrapper = new QueryWrapper<>();
        wrapper.eq("judges_name",result.getJudgesName());
        wrapper.eq("group_id",result.getGroupId());
        Score results = resultMapper.selectOne(wrapper);
        Map<String,Object> data = new HashMap<>();
        if(results!=null){
            return null;
        }
        double cmtScore  = result.getCmtScore();
        double divScore  = result.getDivScore();
        double uiScore   = result.getUiScore();
        double workScore = result.getWorkScore();
        double finalScore= workScore*(0.4) + uiScore*(0.1) + divScore*(0.1) + cmtScore*(0.4);
        result.setScore(finalScore);
        int insert = resultMapper.insert(result);
        if(insert == 1){
            data.put("最终成绩",finalScore);
            return data;
        }else{
            return null;
        }
    }
}
