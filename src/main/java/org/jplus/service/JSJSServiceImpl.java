package org.jplus.service;

import org.jplus.mapper.JSJSMapper;
import org.jplus.pojo.JSJS;
import org.jplus.pojo.ZDXSLW;
import org.jplus.pojo.queryVo.JsjsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wb
 * @date 2019/10/31 - 18:54
 */
@Service
public class JSJSServiceImpl implements JSJSService {


    @Autowired
    private JSJSMapper jSJSMapper;

    @Override
    public void updateZDXSLW(ZDXSLW zDXSLW) {
        jSJSMapper.updateZDXSLW(zDXSLW);
    }

    @Override
    public void addJSJS(JSJS jSJS) {
        jSJSMapper.addJSJS(jSJS);
    }

    @Override
    public Float getAllLwGzl(String gh, Integer year) {
        return jSJSMapper.getAllLwGzl(gh, year);
    }

    @Override
    public Float getAllGzl(String gh, Integer year) {
        return jSJSMapper.getAllGzl(gh, year);
    }

    @Override
    public String getcompetitionLevelByBM(Integer jsdjbm) {
        return jSJSMapper.getcompetitionLevelByBM(jsdjbm);
    }

    @Override
    public void addZDXSLW(ZDXSLW zDXSLW) {
        jSJSMapper.addZDXSLW(zDXSLW);
    }

    @Override
    public List<JsjsVo> getTeacherCompetitionList(String gh, Integer year) {
        return jSJSMapper.getTeacherCompetitionList(gh, year);
    }

    /*@Override
    public List<JSJS> getTeacherCompetitionList(String gh, Integer year) {
        return jSJSMapper.getTeacherCompetitionList(gh, year);
    }*/

    @Override
    public Integer getGzl(Integer teacherCompetitioncategory) {
        return jSJSMapper.getGzl(teacherCompetitioncategory);
    }

    @Override
    public void remove(Integer id) {
        jSJSMapper.remove(id);
    }
}
