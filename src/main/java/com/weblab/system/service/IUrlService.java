package com.weblab.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.weblab.system.entity.Url;

import java.util.Map;

public interface IUrlService extends IService<Url> {
    Map<String, Object> getAll();

}
