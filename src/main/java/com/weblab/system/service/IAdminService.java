package com.weblab.system.service;

import com.weblab.system.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;
import java.util.Objects;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author inkslab
 * @since 2023-04-12
 */
public interface IAdminService extends IService<Admin> {

    public Map<String, Object> AdminLogin(Admin admin);
}
