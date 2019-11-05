package org.jplus.service;

import org.jplus.mapper.ZDXSJSMapper;
import org.jplus.pojo.ZDXSJS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wb
 * @date 2019/10/31 - 14:45
 */
@Service
public class ZDXSJSServiceImpl implements ZDXSJSService {

    @Autowired
    private ZDXSJSMapper zDXSJSMapper;

    @Override
    public void addZDXSJS(ZDXSJS zDXSJS) {
        zDXSJSMapper.addZDXSJS(zDXSJS);
    }

    @Override
    public List<ZDXSJS> getStudentCompetitionList() {
        return zDXSJSMapper.getStudentCompetitionList();
    }

    @Override
    public float getAllGzl() {
        return zDXSJSMapper.getAllGzl();
    }

    @Override
    public float getGzl(int competition, int contestLevel) {
        return zDXSJSMapper.getGzl(competition, contestLevel);
    }

}
