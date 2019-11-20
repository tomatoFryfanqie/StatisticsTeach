package org.jplus.mapper;

import org.apache.ibatis.annotations.Param;
import org.jplus.pojo.masterCompartitionAndOther.YJSQTJX;
import org.springframework.stereotype.Repository;

/**
 * @author wb
 * @date 2019/11/8 - 10:15
 */
@Repository
public interface YJSQTJXMapper {
    void addYJSQTJX(YJSQTJX yJSQTJX);

    Float getAllQtGzl(@Param("gh") String gh, @Param("nd") Integer nd);

    YJSQTJX findYJSQTJXByGhAndYear(@Param("gh") String gh, @Param("nd") Integer nd);

    Integer isOnlyForOneYear(@Param("gh") String gh, @Param("nd") Integer nd);

    void updateYJSQTJX(YJSQTJX yJSQTJX);
}
