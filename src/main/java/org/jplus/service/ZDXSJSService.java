package org.jplus.service;

import org.jplus.pojo.ZDXSJS;
import org.jplus.pojo.ZDXSLW;
import org.jplus.pojo.masterCompartitionAndOther.ZDSSLW;

import java.util.List;

/**
 * @author wb
 * @date 2019/10/31 - 14:43
 */
public interface ZDXSJSService {
    /**
     * 获取工作量信息
     * */
    void addZDXSJS(ZDXSJS zDXSJS);

    List<ZDXSJS> getStudentCompetitionList(String gh, int nd);

    float getGzl(int competition, int contestLevel);

    float getAllGzl(String gh, int year);

    void remove(Integer id);

    ZDXSLW findZDXSLWByGhAndYear(String gh, int year);

    List<ZDXSJS> getStudentCompetitionList2(String gh, int year);

    float getAllGzl2(String gh, int year);

    int isOnlyForOneYear(String gh, int year);
}
