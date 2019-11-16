package org.jplus.service;

import org.jplus.mapper.ZDSSLWMapper;
import org.jplus.pojo.masterCompartitionAndOther.ZDSSLW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wb
 * @date 2019/11/8 - 9:40
 */
@Service
public class ZDSSLWServiceImpl implements ZDSSLWService {

    @Autowired
    private ZDSSLWMapper zDSSLWMapper;

    @Override
    public int isOnlyForOneYear(String gh, int year) {
        return zDSSLWMapper.isOnlyForOneYear(gh, year);
    }

    @Override
    public void updateZDSSLW(ZDSSLW zDSSLW) {
        zDSSLWMapper.updateZDSSLW(zDSSLW);
    }

    @Override
    public float getAllMasterLwGzl(String gh, int year) {
        return zDSSLWMapper.getAllMasterLwGzl(gh, year);
    }

    @Override
    public ZDSSLW findZDSSLWByGhAndYear(String gh, int year) {
        return zDSSLWMapper.findZDSSLWByGhAndYear(gh, year);
    }

    @Override
    public void addZDSSLW(ZDSSLW zDSSLW) {
        zDSSLWMapper.addZDSSLW(zDSSLW);
    }
}
