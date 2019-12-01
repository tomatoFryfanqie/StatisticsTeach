package org.jplus.service;

import org.attoparser.dom.INestableNode;
import org.jplus.mapper.TjztMapper;
import org.jplus.pojo.Tjzt.Tjzt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;

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
    public void addTjzt(String gh, Integer tjzt,Integer shzt) {
        tjztMapper.addTjzt(gh,tjzt,shzt);
    }

    @Override
    public void updateTjzt(String gh, Timestamp date) {
        tjztMapper.updateTjzt(gh,date);
    }

    @Override
    public void insertTJB(Integer years,String gh) {
        tjztMapper.insertTJB(years,gh);
    }
}
