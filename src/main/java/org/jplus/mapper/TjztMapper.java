package org.jplus.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.jplus.pojo.Tjzt.Tjzt;
import org.springframework.stereotype.Component;

/**
 * @BelongsProject: StatisticsTeach
 * @BelongsPackage: org.jplus.mapper
 * @Author: lzh
 * @CreateTime: 2019/11/6
 * @Description: Description
 */
@Component
public interface TjztMapper {

    Tjzt getTjzt(@Param("gh") String gh);

    void addTjzt(@Param("gh") String gh, @Param("tjzt") Integer tjzt);

    @Update("update tjzt set tjzt=1 where gh=#{gh}")
    void updateTjzt(String gh);
}
