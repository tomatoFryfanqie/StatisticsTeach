package org.jplus.service;


import org.jplus.pojo.QTJXGZ;

/**
 * @author wb
 * @date 2019/11/1 - 14:17
 */
public interface QTJXGZService {
    void addQTJXGZ(QTJXGZ qTJXGZ);

    Float getAllQtGzl(String gh, Integer year);

    QTJXGZ findQTJXGZByGhAndYear(String gh, Integer year);

    Integer isOnlyForOneYear(String gh, Integer currentYear);

    void updateQTJXGZ(QTJXGZ qTJXGZ);
}
