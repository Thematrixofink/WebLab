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
    public Users UsersLogin(LoginUserVo userVo) {
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name",userVo.getUsername());
        wrapper.eq("password",userVo.getPassword());
        wrapper.eq("status",userVo.getIdentity());
        Users login = usersMapper.selectOne(wrapper);
        if(login != null){
            return login;
        }
        return null;
    }

    @Override
    public Users setPassword(LoginUserVo userVo) {
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", userVo.getUsername());
        Users users = usersMapper.selectOne(wrapper);
        //如果为空，说明不存在此用户
        if (users == null) {
            return null;
        } else {
            users.setPassword(userVo.getPassword());
            UpdateWrapper<Users> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("user_name",userVo.getUsername());
            int update = usersMapper.update(users,updateWrapper);
            if (update == 1) {
                return users;
            } else {
                return null;
            }
        }
    }

    @Override
    public Map<String, Object> getScore(Integer groupId) {
        QueryWrapper<Score> wrapper = new QueryWrapper<>();
        //只能查询本组的，而且状态是已经提交的成绩
        wrapper.eq("status",1);
        wrapper.eq("group_id",groupId);
        List<Score> results = resultMapper.selectList(wrapper);
        if(results.size() == 0){
            return null;
        }else{
            //说明有这个成绩
            Map<String,Object> map = new HashMap<>();
            List<Score> re1 = new ArrayList<>(results);
            map.put("详细成绩",re1);
            //如果有3条以上的成绩，那么我们就删去最高分或者最低分
            if(re1.size() > 2) {
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
                results.remove(results.size() - 1);
                //删去了最高分和最低分
                double sum = 0.0;
                for (Score r :
                        results) {
                    sum = sum + r.getScore();
                }
                double avS = sum / results.size();
                map.put("最后成绩", avS);
            }
            //如果我们就两个评分记录，那么我们就取平均值吧
            else if(re1.size() == 2){
                double avs = (re1.get(0).getScore() + re1.get(1).getScore())/2;
                map.put("最后成绩",avs);
            }
            else if(re1.size() == 1){
                map.put("最后成绩",re1.get(0).getScore());
            }
            return map;
        }
    }

    @Override
    public Map<String, Object> setGroup(String username, Integer groupId) {
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name",username);
        Users users = usersMapper.selectOne(wrapper);
        UpdateWrapper<Users> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("user_name",username);
        if(users == null || users.getStatus()==1){
            return null;
        }else{
            users.setGroupId(groupId);
            int update = usersMapper.update(users, updateWrapper);
            if(update == 1){
                Map<String,Object> data = new HashMap<>();
                data.put("修改后",users);
                return data;
            }
            return null;
        }
    }
}
