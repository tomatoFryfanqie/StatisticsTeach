package org.jplus.mapper;

import org.apache.ibatis.annotations.Param;
import org.jplus.pojo.masterCompartitionAndOther.ZDSSLW;
import org.springframework.stereotype.Repository;


@Repository
public interface ZDSSLWMapper {
    void addZDSSLW(ZDSSLW zDSSLW);

    Float getAllMasterLwGzl(@Param("gh") String gh, @Param("nd") Integer nd);

    ZDSSLW findZDSSLWByGhAndYear(@Param("gh") String gh, @Param("nd") Integer nd);

    Integer isOnlyForOneYear(@Param("gh") String gh, @Param("nd") Integer nd);

    void updateZDSSLW(ZDSSLW zDSSLW);
}
