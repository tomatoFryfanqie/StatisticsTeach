package org.jplus.service;

import org.jplus.pojo.Tjzt.Tjzt;

/**
 * @BelongsProject: StatisticsTeach
 * @BelongsPackage: org.jplus.service
 * @Author: lzh
 * @CreateTime: 2019/11/6
 * @Description: Description
 */
public interface TjztService {
    Tjzt getTjzt(String gh);

    void addTjzt(String gh, Integer tjzt);

    void updateTjzt(String gh);
}
