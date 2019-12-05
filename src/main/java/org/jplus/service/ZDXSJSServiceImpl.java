package org.jplus.service;

import org.jplus.mapper.ZDXSJSMapper;
import org.jplus.pojo.undergraduateCompatitonAndOther.ZDXSJS;
import org.jplus.pojo.undergraduateCompatitonAndOther.ZDXSLW;
import org.jplus.pojo.queryVo.ZdxsjsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ZDXSJSServiceImpl implements ZDXSJSService {


    @Autowired
    private ZDXSJSMapper zDXSJSMapper;

    @Override
    public List<ZdxsjsVo> getStudentCompetitionList(String gh, Integer currentYear) {
        return zDXSJSMapper.getStudentCompetitionList(gh, currentYear);
    }

    @Override
    public Integer isOnlyForOneYear(String gh, Integer year) {
        return zDXSJSMapper.isOnlyForOneYear(gh, year);
    }

    @Override
    public void addZDXSJS(ZDXSJS zDXSJS) {
        zDXSJSMapper.addZDXSJS(zDXSJS);
    }

    /*@Override
    public List<ZDXSJS> getStudentCompetitionList(String gh, Integer nd) {
        return zDXSJSMapper.getStudentCompetitionList(gh, nd);
    }*/

    @Override
    public Float getAllGzl(String gh, Integer year) {
        return zDXSJSMapper.getAllGzl(gh, year);
    }

    @Override
    public List<ZdxsjsVo> getStudentCompetitionList2(String gh, Integer year) {
        return zDXSJSMapper.getStudentCompetitionList2(gh, year);
    }

    @Override
    public Float getAllGzl2(String gh, Integer year) {
        return zDXSJSMapper.getAllGzl2(gh, year);
    }

    /*@Override
    public List<ZDXSJS> getStudentCompetitionList2(String gh, Integer year) {
        return zDXSJSMapper.getStudentCompetitionList2(gh, year);
    }*/

    @Override
    public ZDXSLW findZDXSLWByGhAndYear(String gh, Integer year) {
        return zDXSJSMapper.findZDXSLWByGhAndYear(gh, year);
    }

    @Override
    public void remove(Integer id) {
        zDXSJSMapper.remove(id);
    }

    @Override
    public Float getGzl(Integer competition, Integer contestLevel) {
        return zDXSJSMapper.getGzl(competition, contestLevel);
    }

}
