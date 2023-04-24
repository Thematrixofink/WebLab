package com.weblab.system.service;

import com.weblab.system.entity.Users;
import com.baomidou.mybatisplus.extension.service.IService;
import com.weblab.system.entity.vo.LoginUserVo;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author inkslab
 * @since 2023-04-12
 */
public interface IUsersService extends IService<Users> {
     Users UsersLogin(LoginUserVo userVo);

    Users setPassword(LoginUserVo userVo);

    Map<String, Object> getScore(Integer groupId);

    Map<String, Object> setGroup(String username, Integer groupId);

}

