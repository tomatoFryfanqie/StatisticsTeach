package org.jplus.service;

import org.jplus.mapper.JbxxMapper;
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
public class JbxxServiceImpl implements JbxxService {

    @Autowired
    private JbxxMapper jbxxMapper;

    @Override
    public Jbxx getJbxxInfo(String gh) {
        return jbxxMapper.getJbxxInfo(gh);
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

    @Override
    public void updateBasisInfo(JbxxAccpet jbxxAccpet) {
        jbxxMapper.updateBasisInfo(jbxxAccpet);
    }
}
