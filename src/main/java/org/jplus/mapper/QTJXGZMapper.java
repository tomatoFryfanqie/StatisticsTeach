package org.jplus.mapper;

import org.apache.ibatis.annotations.Param;
import org.jplus.pojo.QTJXGZ;
import org.springframework.stereotype.Repository;

/**
 * @author wb
 * @date 2019/11/1 - 14:18
 */
@Repository
public interface QTJXGZMapper {

    void addQTJXGZ(QTJXGZ qTJXGZ);

    float getAllQtGzl(@Param("gh") String gh, @Param("nd") int year);

    QTJXGZ findQTJXGZByGhAndYear(@Param("gh") String gh, @Param("nd") int year);

    int isOnlyForOneYear(@Param("gh") String gh, @Param("nd") int year);

    void updateQTJXGZ(QTJXGZ qTJXGZ);
}
