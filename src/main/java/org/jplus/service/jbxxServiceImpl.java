package org.jplus.service;

import org.jplus.mapper.jbxxMapper;
import org.jplus.pojo.basisInfo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: StatisticsTeach
 * @BelongsPackage: org.jplus.service
 * @Author: lzh
 * @CreateTime: 2019/10/31
 * @Description: Description
 */
@Service
public class jbxxServiceImpl implements jbxxService {

    @Autowired
    private jbxxMapper jbxxMapper;

    @Override
    public Jbxx getJbxxInfo() {
        return jbxxMapper.getJbxxInfo();
    }

    @Override
    public List<Yxbm> getYxbmInfo() {
        return jbxxMapper.getYxbmInfo();
    }

    @Override
    public List<Zwbm> getZwbmInfo() {
        return jbxxMapper.getZwbmInfo();
    }

    @Override
    public List<Zcbm> getZcbmInfo() {
        return jbxxMapper.getZcbmInfo();
    }

    @Override
    public List<Gwlxbm> getGwlxbmInfo() {
        return jbxxMapper.getGwlxbmInfo();
    }
}
