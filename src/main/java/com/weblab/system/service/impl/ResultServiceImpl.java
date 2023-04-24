package com.weblab.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.weblab.system.entity.Score;
import com.weblab.system.mapper.ResultMapper;
import com.weblab.system.service.IResultService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
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
    public Score saveResult(Score result) {
        QueryWrapper<Score> wrapper = new QueryWrapper<>();
        wrapper.eq("judges_name",result.getJudgesName());
        wrapper.eq("group_id",result.getGroupId());
        Score results = resultMapper.selectOne(wrapper);
        if(results!=null){
            return null;
        }
        double cmtScore  = result.getCmtScore();
        double divScore  = result.getDivScore();
        double uiScore   = result.getUiScore();
        double workScore = result.getWorkScore();
        double finalScore= workScore*(0.4) + uiScore*(0.1) + divScore*(0.1) + cmtScore*(0.4);
        result.setScore(finalScore);
        result.setStatus(0);
        int insert = resultMapper.insert(result);
        if(insert == 1){
            return result;
        }else{
            return null;
        }
    }

    @Override
    public List<Score> getNosubmit(String judgeName) {
        QueryWrapper<Score> wrapper = new QueryWrapper<>();
        wrapper.eq("status",0);
        wrapper.eq("judges_name",judgeName);
        List<Score> scores = resultMapper.selectList(wrapper);
        if(scores.size() == 0){
            return null;
        }else{
            return scores;
        }
    }
    @Override
    public Map<String, Object> updateSocre(Score score) {
        QueryWrapper<Score> wrapper = new QueryWrapper<>();
        wrapper.eq("group_id",score.getGroupId());
        wrapper.eq("judges_name",score.getJudgesName());
        wrapper.eq("status",0);
        UpdateWrapper<Score> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("group_id",score.getGroupId());
        updateWrapper.eq("judges_name",score.getJudgesName());
        updateWrapper.eq("status",0);
        double finalScore= score.getWorkScore()*(0.4) + score.getCmtScore()*(0.1) + score.getDivScore()*(0.1) + score.getCmtScore()*(0.4);
        score.setScore(finalScore);
        int update = resultMapper.update(score, updateWrapper);
        Score score1 = resultMapper.selectOne(wrapper);
        if(update == 1){
            HashMap<String, Object> map = new HashMap<>();
            map.put("修改后数据",score1);
            return map;
        }else{
            return null;
        }
    }

    @Override
    public Score setResult(Integer groupId, String judgeName) {
        QueryWrapper<Score> wrapper = new QueryWrapper<>();
        wrapper.eq("group_id",groupId);
        wrapper.eq("judges_name",judgeName);
        wrapper.eq("status",0);
        UpdateWrapper<Score> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("group_id",groupId);
        updateWrapper.eq("judges_name",judgeName);
        updateWrapper.eq("status",0);
        Score score = resultMapper.selectOne(wrapper);
        if(score == null){
            return null;
        }else{
            score.setStatus(1);
            int update = resultMapper.update(score, updateWrapper);
            if(update == 1){
                return score;
            }else{
                return null;
            }
        }
    }

    @Override
    public List<Score> getAllScore(String judgeName) {
        QueryWrapper<Score> wrapper = new QueryWrapper<>();
        wrapper.eq("judges_name",judgeName);
        List<Score> scores = resultMapper.selectList(wrapper);
        if(scores == null){
            return null;
        }else{
            return scores;
        }
    }

    @Override
    public List<Score> getAllScore() {
        List<Score> scores = resultMapper.selectList(null);
        if(scores == null){
            return null;
        }else{
            return scores;
        }
    }

    @Override
    public Map<String, Object> changeStatus(String groupId,String judgeName) {
        QueryWrapper<Score> wrapper = new QueryWrapper<>();
        wrapper.eq("group_id",groupId);
        wrapper.eq("judges_name",judgeName);
        wrapper.eq("status",1);
        UpdateWrapper<Score> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("group_id",groupId);
        updateWrapper.eq("judges_name",judgeName);
        Score score = resultMapper.selectOne(wrapper);
        if(score==null){
            return null;
        }
        score.setStatus(0);
        int update = resultMapper.update(score, updateWrapper);
        if(update == 1){
            Map<String,Object> data = new HashMap<>();
            data.put("修改后",score);
            return data;
        }
        return null;
    }
}
