package org.jplus.service;

import org.jplus.pojo.undergraduateCompatitonAndOther.ZDXSJS;
import org.jplus.pojo.undergraduateCompatitonAndOther.ZDXSLW;
import org.jplus.pojo.queryVo.ZdxsjsVo;

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

    //List<ZDXSJS> getStudentCompetitionList(String gh, Integer nd);

    Float getGzl(Integer competition, Integer contestLevel);

    Float getAllGzl(String gh, Integer year);

    void remove(Integer id);

    ZDXSLW findZDXSLWByGhAndYear(String gh, Integer year);

    //List<ZDXSJS> getStudentCompetitionList2(String gh, Integer year);

    Float getAllGzl2(String gh, Integer year);

    Integer isOnlyForOneYear(String gh, Integer year);

    List<ZdxsjsVo> getStudentCompetitionList(String gh, Integer currentYear);

    List<ZdxsjsVo> getStudentCompetitionList2(String gh, Integer currentYear);
}
