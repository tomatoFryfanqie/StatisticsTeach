package org.jplus.mapper;

import org.apache.ibatis.annotations.Param;
import org.jplus.pojo.Tjzt.Tjzt;

/**
 * @BelongsProject: StatisticsTeach
 * @BelongsPackage: org.jplus.mapper
 * @Author: lzh
 * @CreateTime: 2019/11/6
 * @Description: Description
 */
public interface TjztMapper {

    Tjzt getTjzt(@Param("gh") String gh);

    void addTjzt(@Param("gh") String gh, @Param("tjzt") Integer tjzt);
}
