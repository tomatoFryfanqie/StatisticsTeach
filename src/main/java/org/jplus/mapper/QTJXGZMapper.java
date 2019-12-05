package org.jplus.mapper;

import org.apache.ibatis.annotations.Param;
import org.jplus.pojo.undergraduateCompatitonAndOther.QTJXGZ;
import org.springframework.stereotype.Repository;


@Repository
public interface QTJXGZMapper {

    void addQTJXGZ(QTJXGZ qTJXGZ);

    Float getAllQtGzl(@Param("gh") String gh, @Param("nd") Integer year);

    QTJXGZ findQTJXGZByGhAndYear(@Param("gh") String gh, @Param("nd") Integer year);

    Integer isOnlyForOneYear(@Param("gh") String gh, @Param("nd") Integer year);

    void updateQTJXGZ(QTJXGZ qTJXGZ);
}
