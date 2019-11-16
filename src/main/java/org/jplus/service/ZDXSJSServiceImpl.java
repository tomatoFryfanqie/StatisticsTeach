package org.jplus.service;

import org.jplus.mapper.ZDXSJSMapper;
import org.jplus.pojo.ZDXSJS;
import org.jplus.pojo.ZDXSLW;
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
    public int isOnlyForOneYear(String gh, int year) {
        return zDXSJSMapper.isOnlyForOneYear(gh, year);
    }

    @Override
    public void addZDXSJS(ZDXSJS zDXSJS) {
        zDXSJSMapper.addZDXSJS(zDXSJS);
    }

    @Override
    public List<ZDXSJS> getStudentCompetitionList(String gh, int nd) {
        return zDXSJSMapper.getStudentCompetitionList(gh, nd);
    }

    @Override
    public float getAllGzl(String gh, int year) {
        return zDXSJSMapper.getAllGzl(gh, year);
    }

    @Override
    public float getAllGzl2(String gh, int year) {
        return zDXSJSMapper.getAllGzl2(gh, year);
    }

    @Override
    public List<ZDXSJS> getStudentCompetitionList2(String gh, int year) {
        return zDXSJSMapper.getStudentCompetitionList2(gh, year);
    }

    @Override
    public ZDXSLW findZDXSLWByGhAndYear(String gh, int year) {
        return zDXSJSMapper.findZDXSLWByGhAndYear(gh, year);
    }

    @Override
    public void remove(Integer id) {
        zDXSJSMapper.remove(id);
    }

    @Override
    public float getGzl(int competition, int contestLevel) {
        return zDXSJSMapper.getGzl(competition, contestLevel);
    }

}
