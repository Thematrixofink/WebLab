package com.weblab.system.mapper;

import com.weblab.system.entity.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.weblab.system.entity.Users;
import com.weblab.system.entity.vo.LoginUserVo;
import lombok.extern.java.Log;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author inkslab
 * @since 2023-04-12
 */
public interface AdminMapper extends BaseMapper<Admin> {

    List<LoginUserVo> adLogin(LoginUserVo admin);

    List<Users> getUsers();

    Users getUserByName(String name);
}
