package org.jplus.service;

import org.jplus.mapper.QTJXGZMapper;
import org.jplus.pojo.QTJXGZ;
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
    public float getAllQtGzl() {
        return qTJXGZMapper.getAllQtGzl();
    }

    @Override
    public void addQTJXGZ(QTJXGZ qTJXGZ) {
        qTJXGZMapper.addQTJXGZ(qTJXGZ);
    }
}
