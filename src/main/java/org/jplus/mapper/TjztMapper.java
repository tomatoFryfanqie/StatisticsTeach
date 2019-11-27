package org.jplus.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.jplus.pojo.Tjzt.Tjzt;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Timestamp;

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

    void addTjzt(@Param("gh") String gh, @Param("tjzt") Integer tjzt,@Param("shzt")Integer shzt);

    void updateTjzt(@Param("gh") String gh, @Param("tjsj") Timestamp tjsj);

    void insertTJB(Integer years,String gh);
}
