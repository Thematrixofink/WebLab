package com.weblab.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.weblab.system.entity.Url;

import java.util.List;
import java.util.Map;

public interface IUrlService extends IService<Url> {
    List<Url> getAll();

    Map<String, Object> setUrl(Integer groupId, String videoUrl, String projectUrl);

    Map<String, Object> changeUrl(Integer groupId, String videoUrl, String projectUrl);
}
