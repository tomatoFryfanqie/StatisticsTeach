package org.jplus.service;

import org.jplus.mapper.TjztMapper;
import org.jplus.pojo.Tjzt.Tjzt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: StatisticsTeach
 * @BelongsPackage: org.jplus.service
 * @Author: lzh
 * @CreateTime: 2019/11/6
 * @Description: Description
 */
@Service
public class TjztServiceImpl implements TjztService {

    @Autowired
    private TjztMapper tjztMapper;

    @Override
    public Tjzt getTjzt(String gh) {
        return tjztMapper.getTjzt(gh);
    }

    @Override
    public void addTjzt(String gh, Integer tjzt) {
        tjztMapper.addTjzt(gh,tjzt);
    }

    @Override
    public void updateTjzt(String gh) {
        tjztMapper.updateTjzt(gh);
    }
}
