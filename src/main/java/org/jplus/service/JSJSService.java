package org.jplus.service;

import org.jplus.pojo.undergraduateCompatitonAndOther.JSJS;
import org.jplus.pojo.undergraduateCompatitonAndOther.ZDXSLW;
import org.jplus.pojo.queryVo.JsjsVo;

import java.util.List;


public interface JSJSService {
    Integer getGzl(Integer teacherCompetitioncategory);

    void addJSJS(JSJS jSJS);

    //List<JSJS> getTeacherCompetitionList(String gh,Integer year);

    void addZDXSLW(ZDXSLW zDXSLW);

    Float getAllGzl(String gh, Integer year);

    Float getAllLwGzl(String gh, Integer year);

    void remove(Integer id);

    void updateZDXSLW(ZDXSLW zDXSLW);

    List<JsjsVo> getTeacherCompetitionList(String gh, Integer currentYear);

    String getcompetitionLevelByBM(Integer jsdjbm);
}
