package org.jplus.service;

import org.jplus.mapper.YJSQTJXMapper;
import org.jplus.pojo.masterCompartitionAndOther.YJSQTJX;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class YJSQTJXServiceImpl implements YJSQTJXService {

    @Autowired
    private YJSQTJXMapper yJSQTJXMapper;

    @Override
    public Integer isOnlyForOneYear(String gh, Integer year) {
        return yJSQTJXMapper.isOnlyForOneYear(gh, year);
    }

    @Override
    public void updateYJSQTJX(YJSQTJX yJSQTJX) {
        yJSQTJXMapper.updateYJSQTJX(yJSQTJX);
    }

    @Override
    public Float getAllQtGzl(String gh, Integer year) {
        return yJSQTJXMapper.getAllQtGzl(gh, year);
    }

    @Override
    public YJSQTJX findYJSQTJXByGhAndYear(String gh, Integer year) {
        return yJSQTJXMapper.findYJSQTJXByGhAndYear(gh, year);
    }

    @Override
    public void addYJSQTJX(YJSQTJX yJSQTJX) {
        yJSQTJXMapper.addYJSQTJX(yJSQTJX);
    }
}
