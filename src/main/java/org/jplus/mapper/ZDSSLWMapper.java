package org.jplus.mapper;

import org.jplus.pojo.masterCompartitionAndOther.ZDSSLW;
import org.springframework.stereotype.Repository;

/**
 * @author wb
 * @date 2019/11/8 - 10:14
 */
@Repository
public interface ZDSSLWMapper {
    void addZDSSLW(ZDSSLW zDSSLW);

    float getAllMasterLwGzl();
}
