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
    public float getAllMasterLwGzl() {
        return zDSSLWMapper.getAllMasterLwGzl();
    }

    @Override
    public void addZDSSLW(ZDSSLW zDSSLW) {
        zDSSLWMapper.addZDSSLW(zDSSLW);
    }
}
