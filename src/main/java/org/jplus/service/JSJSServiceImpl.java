package org.jplus.service;

import org.jplus.mapper.JSJSMapper;
import org.jplus.pojo.JSJS;
import org.jplus.pojo.ZDXSLW;
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
    public float getAllLwGzl(String gh, int year) {
        return jSJSMapper.getAllLwGzl(gh, year);
    }

    @Override
    public float getAllGzl(String gh, int year) {
        return jSJSMapper.getAllGzl(gh, year);
    }

    @Override
    public void addZDXSLW(ZDXSLW zDXSLW) {
        jSJSMapper.addZDXSLW(zDXSLW);
    }

    @Override
    public List<JSJS> getTeacherCompetitionList(String gh, int year) {
        return jSJSMapper.getTeacherCompetitionList(gh, year);
    }

    @Override
    public int getGzl(int teacherCompetitioncategory) {
        return jSJSMapper.getGzl(teacherCompetitioncategory);
    }

    @Override
    public void remove(Integer id) {
        jSJSMapper.remove(id);
    }
}
