package com.weblab.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weblab.system.entity.Url;
import com.weblab.system.mapper.UrlMapper;
import com.weblab.system.service.IUrlService;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class UrlServiceImpl extends ServiceImpl<UrlMapper,Url> implements IUrlService {

    @Override
    public List<Url> getAll() {
        List<Url> urls = this.baseMapper.selectList(null);
        if(urls.size() == 0) {
            return null;
        }
        return urls;
    }

    @Override
    public Map<String, Object> setUrl(Integer groupId, String videoUrl, String webUrl) {
        Url url = new Url();
        url.setGroupId(groupId);
        url.setVideoUrl(videoUrl);
        url.setWebUrl(webUrl);
        QueryWrapper<Url> wrapper = new QueryWrapper<>();
        wrapper.eq("group_id",groupId);
        Url url1 = baseMapper.selectOne(wrapper);
        if(url1 != null){
            Map<String, Object> data = new HashMap<>();
            data.put("error","地址已经存在！");
            return data;
        }
        int insert = this.baseMapper.insert(url);
        if(insert == 1){
            Map<String, Object> data = new HashMap<>();
            data.put("url",url);
            return data;
        }
        return null;
    }

    @Override
    public Map<String, Object> changeUrl(Integer groupId, String videoUrl, String projectUrl) {
        QueryWrapper<Url> wrapper = new QueryWrapper<>();
        wrapper.eq("group_id",groupId);
        UpdateWrapper<Url> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("group_id",groupId);
        Url url = baseMapper.selectOne(wrapper);
        if(url == null){
            return null;
        }else{
            url.setWebUrl(projectUrl);
            url.setVideoUrl(videoUrl);
            int update = baseMapper.update(url, updateWrapper);
            if(update == 1){
                Map<String,Object> data = new HashMap<>();
                data.put("修改后",url);
                return data;
            }
            return null;
        }
    }

}
