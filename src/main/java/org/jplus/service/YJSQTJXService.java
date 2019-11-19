package org.jplus.service;

import org.jplus.pojo.masterCompartitionAndOther.YJSQTJX; /**
 * @author wb
 * @date 2019/11/8 - 15:33
 */
public interface YJSQTJXService {
    void addYJSQTJX(YJSQTJX yJSQTJX);

    float getAllQtGzl(String gh, int year);

    YJSQTJX findYJSQTJXByGhAndYear(String gh, int year);

    int isOnlyForOneYear(String gh, int currentYear);

    void updateYJSQTJX(YJSQTJX yJSQTJX);
}
