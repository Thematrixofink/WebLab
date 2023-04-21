package com.weblab.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.weblab.system.entity.Score;
import com.weblab.system.entity.Users;
import com.weblab.system.entity.vo.LoginUserVo;
import com.weblab.system.mapper.ResultMapper;
import com.weblab.system.mapper.UsersMapper;
import com.weblab.system.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author inkslab
 * @since 2023-04-12
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {
    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private ResultMapper resultMapper;

    @Override
    public Map<String, Object> UsersLogin(LoginUserVo userVo) {
        List<LoginUserVo> login = usersMapper.usLogin(userVo);
        LoginUserVo user = login.get(0);
        if (login.size() > 0) {
            String key = "user:" + UUID.randomUUID();
            Map<String, Object> data = new HashMap<>();
            data.put("token", key);
            if (user.getIdentity().equals("1")) {
                data.put("identify", "教师");
                data.put("ifJudges", 1);
            } else {
                data.put("identify", "学生");
                if (user.getIfJudges().equals(1)) {
                    data.put("ifJudges", 1);
                } else {
                    data.put("ifJudges", 0);
                }
            }
            return data;
        }
        return null;
    }

    @Override
    public Map<String, Object> setPassword(LoginUserVo userVo) {
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", userVo.getUsername());
        Users users = usersMapper.selectOne(wrapper);
        Map<String, Object> data = new HashMap<>();
        //如果为空，说明不存在此用户
        if (users == null) {
            return null;
        } else {
            users.setPassword(userVo.getPassword());
            UpdateWrapper<Users> wrapper1 = new UpdateWrapper<>();
            wrapper1.eq("user_name", userVo.getUsername());
            int update = usersMapper.update(users,wrapper1);
            if (update == 1) {
                return data;
            } else {
                return null;
            }
        }
    }

    @Override
    public Map<String, Object> getScore(Integer groupId) {
        QueryWrapper<Score> wrapper = new QueryWrapper<>();
        wrapper.eq("group_id",groupId);
        List<Score> results = resultMapper.selectList(wrapper);
        if(results.size() == 0){
            return null;
        }else{
            //说明有这个成绩
            Map<String,Object> map = new HashMap<>();
            List<Score> re1 = new ArrayList<>(results);
            map.put("详细成绩",re1);
            //在计算出总成绩
            Comparator<Score> Comparator = new Comparator<>() {
                @Override
                public int compare(Score o1, Score o2) {
                    double r = o1.getScore() - o2.getScore();
                    return r > 0 ? 1 : -1;
                }
            };
            results.sort(Comparator);
            results.remove(0);
            results.remove(results.size()-1);
            //删去了最高分和最低分
            double sum = 0.0;
            for (Score r :
                    results) {
                sum = sum + r.getScore();
            }
            double avS = sum / results.size();
            map.put("最后成绩",avS);
            return map;
        }
    }
}
