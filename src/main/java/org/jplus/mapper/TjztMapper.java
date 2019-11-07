package org.jplus.mapper;

import org.jplus.pojo.Tjzt.Tjzt;

/**
 * @BelongsProject: StatisticsTeach
 * @BelongsPackage: org.jplus.mapper
 * @Author: lzh
 * @CreateTime: 2019/11/6
 * @Description: Description
 */
public interface TjztMapper {

    Tjzt getTjzt(String gh);

    void addTjzt(String gh, Integer tjzt);
}
