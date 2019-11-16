package org.jplus.service;

import org.jplus.pojo.masterCompartitionAndOther.ZDSSLW; /**
 * @author wb
 * @date 2019/11/8 - 9:40
 */
public interface ZDSSLWService {
    void addZDSSLW(ZDSSLW zDSSLW);

    float getAllMasterLwGzl(String gh, int year);

    ZDSSLW findZDSSLWByGhAndYear(String gh, int year);

    int isOnlyForOneYear(String gh, int currentYear);

    void updateZDSSLW(ZDSSLW zDSSLW);
}
