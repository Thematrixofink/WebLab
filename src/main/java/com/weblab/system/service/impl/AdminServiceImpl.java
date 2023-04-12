package com.weblab.system.service.impl;

import com.weblab.system.entity.Admin;
import com.weblab.system.mapper.AdminMapper;
import com.weblab.system.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author inkslab
 * @since 2023-04-12
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

}
