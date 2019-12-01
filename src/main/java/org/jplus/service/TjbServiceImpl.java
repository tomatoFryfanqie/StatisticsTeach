package org.jplus.service;

import org.jplus.mapper.TjbMapper;
import org.jplus.pojo.Tjzt.Tjb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: StatisticsTeach
 * @BelongsPackage: org.jplus.service
 * @Author: lzh
 * @CreateTime: 2019/11/26
 * @Description: Description
 */
@Service
public class TjbServiceImpl implements TjbService {

    @Autowired
    private TjbMapper tjbMapper;

    @Override
    public List<Tjb> getAllTjb() {
        return tjbMapper.getAllTjb();
    }

    @Override
    public List<Tjb> getAllTjbByYxbm(int yxbm) {

        return tjbMapper.getAllTjbByYxbm(yxbm);
    }
}
