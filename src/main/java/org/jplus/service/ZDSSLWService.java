package org.jplus.service;

import org.jplus.pojo.masterCompartitionAndOther.ZDSSLW; /**
 * @author wb
 * @date 2019/11/8 - 9:40
 */
public interface ZDSSLWService {
    void addZDSSLW(ZDSSLW zDSSLW);

    Float getAllMasterLwGzl(String gh, Integer year);

    ZDSSLW findZDSSLWByGhAndYear(String gh, Integer year);

    Integer isOnlyForOneYear(String gh, Integer currentYear);

    void updateZDSSLW(ZDSSLW zDSSLW);
}
