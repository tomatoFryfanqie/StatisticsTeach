package org.jplus.service;

import org.jplus.mapper.ZDSSLWMapper;
import org.jplus.pojo.masterCompartitionAndOther.ZDSSLW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ZDSSLWServiceImpl implements ZDSSLWService {

    @Autowired
    private ZDSSLWMapper zDSSLWMapper;

    @Override
    public Integer isOnlyForOneYear(String gh, Integer year) {
        return zDSSLWMapper.isOnlyForOneYear(gh, year);
    }

    @Override
    public void updateZDSSLW(ZDSSLW zDSSLW) {
        zDSSLWMapper.updateZDSSLW(zDSSLW);
    }

    @Override
    public Float getAllMasterLwGzl(String gh, Integer year) {
        return zDSSLWMapper.getAllMasterLwGzl(gh, year);
    }

    @Override
    public ZDSSLW findZDSSLWByGhAndYear(String gh, Integer year) {
        return zDSSLWMapper.findZDSSLWByGhAndYear(gh, year);
    }

    @Override
    public void addZDSSLW(ZDSSLW zDSSLW) {
        zDSSLWMapper.addZDSSLW(zDSSLW);
    }
}
