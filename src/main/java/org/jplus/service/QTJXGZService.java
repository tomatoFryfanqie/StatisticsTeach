package org.jplus.service;


import org.jplus.pojo.QTJXGZ;

/**
 * @author wb
 * @date 2019/11/1 - 14:17
 */
public interface QTJXGZService {
    void addQTJXGZ(QTJXGZ qTJXGZ);

    float getAllQtGzl(String gh, int year);

    QTJXGZ findQTJXGZByGhAndYear(String gh, int year);

    int isOnlyForOneYear(String gh, int currentYear);

    void updateQTJXGZ(QTJXGZ qTJXGZ);
}
