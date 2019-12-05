package org.jplus.service;

import org.jplus.pojo.masterCompartitionAndOther.ZDSSLW;


public interface ZDSSLWService {
    void addZDSSLW(ZDSSLW zDSSLW);

    Float getAllMasterLwGzl(String gh, Integer year);

    ZDSSLW findZDSSLWByGhAndYear(String gh, Integer year);

    Integer isOnlyForOneYear(String gh, Integer currentYear);

    void updateZDSSLW(ZDSSLW zDSSLW);
}
