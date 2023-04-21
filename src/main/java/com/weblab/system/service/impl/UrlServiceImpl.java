package com.weblab.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.weblab.system.entity.Url;
import com.weblab.system.mapper.UrlMapper;
import com.weblab.system.service.IUrlService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UrlServiceImpl extends ServiceImpl<UrlMapper,Url> implements IUrlService {

    @Override
    public Map<String, Object> getAll() {
        List<Url> urls = this.baseMapper.selectList(null);
        if(urls.size() == 0){
            return null;
        }
        Map<String,Object> data = new HashMap<>();
        for (Url u :
                urls) {
            Integer groupId = u.getGroupId();
            String s = String.valueOf(groupId);
            data.put("组号"+s,u);
        }
        return data;
    }
}
