package com.weblab.system.service;

import com.weblab.system.entity.Score;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author inkslab
 * @since 2023-04-12
 */
public interface IResultService extends IService<Score> {

    Score saveResult(Score result);

    List<Score> getNosubmit(String judgeName);

    Map<String, Object> updateSocre(Score score);

    Score setResult(Integer groupId, String judgeName);


    List<Score> getAllScore(String judgeName);
    List<Score> getAllScore();

    Map<String, Object> changeStatus(String groupId,String judgeName);

}
