package com.weblab.system.mapper;

import com.weblab.system.entity.Users;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.weblab.system.entity.vo.LoginUserVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author inkslab
 * @since 2023-04-12
 */
public interface UsersMapper extends BaseMapper<Users> {

    List<LoginUserVo> usLogin(LoginUserVo userVo);


}
