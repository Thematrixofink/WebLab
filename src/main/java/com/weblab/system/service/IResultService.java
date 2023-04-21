package com.weblab.system.service;

import com.weblab.system.entity.Score;
import com.baomidou.mybatisplus.extension.service.IService;

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

    Map<String, Object> setResult(Score result);

}
