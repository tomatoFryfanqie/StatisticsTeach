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
    public void addJSJS(JSJS jSJS) {
        jSJSMapper.addJSJS(jSJS);
    }

    @Override
    public float getAllLwGzl() {
        return jSJSMapper.getAllLwGzl();
    }

    @Override
    public float getAllGzl() {
        return jSJSMapper.getAllGzl();
    }

    @Override
    public void addZDXSLW(ZDXSLW zDXSLW) {
        jSJSMapper.addZDXSLW(zDXSLW);
    }

    @Override
    public List<JSJS> getTeacherCompetitionList() {
        return jSJSMapper.getTeacherCompetitionList();
    }

    @Override
    public int getGzl(int teacherCompetitioncategory) {
        return jSJSMapper.getGzl(teacherCompetitioncategory);
    }
}
