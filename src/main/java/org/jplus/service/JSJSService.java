package org.jplus.service;

import org.jplus.pojo.JSJS;
import org.jplus.pojo.ZDXSLW;

import java.util.List;

/**
 * @author wb
 * @date 2019/10/31 - 18:53
 */
public interface JSJSService {
    int getGzl(int teacherCompetitioncategory);

    void addJSJS(JSJS jSJS);

    List<JSJS> getTeacherCompetitionList(String gh,int year);

    void addZDXSLW(ZDXSLW zDXSLW);

    float getAllGzl(String gh, int year);

    float getAllLwGzl(String gh, int year);

    void remove(Integer id);

    void updateZDXSLW(ZDXSLW zDXSLW);
}
