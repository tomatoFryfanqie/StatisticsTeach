package org.jplus.service;

import org.jplus.mapper.QTJXGZMapper;
import org.jplus.pojo.undergraduateCompatitonAndOther.QTJXGZ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wb
 * @date 2019/11/1 - 14:18
 */
@Service
public class QTJXGZServiceImpl implements QTJXGZService {

    @Autowired
    private QTJXGZMapper qTJXGZMapper;

    @Override
    public Integer isOnlyForOneYear(String gh, Integer year) {
        return qTJXGZMapper.isOnlyForOneYear(gh, year);
    }

    @Override
    public void updateQTJXGZ(QTJXGZ qTJXGZ) {
        qTJXGZMapper.updateQTJXGZ(qTJXGZ);
    }

    @Override
    public Float getAllQtGzl(String gh, Integer year) {
        return qTJXGZMapper.getAllQtGzl(gh, year);
    }

    @Override
    public QTJXGZ findQTJXGZByGhAndYear(String gh, Integer year) {
        return qTJXGZMapper.findQTJXGZByGhAndYear(gh ,year);
    }

    @Override
    public void addQTJXGZ(QTJXGZ qTJXGZ) {
        qTJXGZMapper.addQTJXGZ(qTJXGZ);
    }
}
