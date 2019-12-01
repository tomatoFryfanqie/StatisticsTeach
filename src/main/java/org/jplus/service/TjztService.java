package org.jplus.service;

import org.jplus.pojo.Tjzt.Tjzt;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @BelongsProject: StatisticsTeach
 * @BelongsPackage: org.jplus.service
 * @Author: lzh
 * @CreateTime: 2019/11/6
 * @Description: Description
 */
public interface TjztService {
    Tjzt getTjzt(String gh);

    void addTjzt(String gh, Integer tjzt,Integer shzt);

    void updateTjzt(String gh , Timestamp date);

    void insertTJB(Integer years,String gh);
}
