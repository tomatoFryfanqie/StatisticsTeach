package org.jplus.mapper;

import org.apache.ibatis.annotations.Param;
import org.jplus.pojo.masterCompartitionAndOther.ZDSSLW;
import org.springframework.stereotype.Repository;

/**
 * @author wb
 * @date 2019/11/8 - 10:14
 */
@Repository
public interface ZDSSLWMapper {
    void addZDSSLW(ZDSSLW zDSSLW);

    float getAllMasterLwGzl(@Param("gh") String gh, @Param("nd") int nd);

    ZDSSLW findZDSSLWByGhAndYear(@Param("gh") String gh, @Param("nd") int nd);

    int isOnlyForOneYear(@Param("gh") String gh, @Param("nd") int nd);

    void updateZDSSLW(ZDSSLW zDSSLW);
}
