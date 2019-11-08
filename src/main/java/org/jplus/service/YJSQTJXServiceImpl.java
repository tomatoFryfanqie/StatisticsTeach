package org.jplus.service;

import org.jplus.mapper.YJSQTJXMapper;
import org.jplus.pojo.masterCompartitionAndOther.YJSQTJX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wb
 * @date 2019/11/8 - 15:34
 */
@Service
public class YJSQTJXServiceImpl implements YJSQTJXService {

    @Autowired
    private YJSQTJXMapper yJSQTJXMapper;

    @Override
    public float getAllQtGzl() {
        return yJSQTJXMapper.getAllQtGzl();
    }

    @Override
    public void addYJSQTJX(YJSQTJX yJSQTJX) {
        yJSQTJXMapper.addYJSQTJX(yJSQTJX);
    }
}
