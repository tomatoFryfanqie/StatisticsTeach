package org.jplus.service;

import org.jplus.pojo.masterCompartitionAndOther.YJSQTJX; /**
 * @author wb
 * @date 2019/11/8 - 15:33
 */
public interface YJSQTJXService {
    void addYJSQTJX(YJSQTJX yJSQTJX);

    Float getAllQtGzl(String gh, Integer year);

    YJSQTJX findYJSQTJXByGhAndYear(String gh, Integer year);

    Integer isOnlyForOneYear(String gh, Integer currentYear);

    void updateYJSQTJX(YJSQTJX yJSQTJX);
}
