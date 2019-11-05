package org.jplus.service;

import org.jplus.pojo.ZDXSJS;

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

    List<ZDXSJS> getStudentCompetitionList();

    float getGzl(int competition, int contestLevel);

    float getAllGzl();
}
