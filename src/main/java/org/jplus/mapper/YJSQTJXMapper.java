package org.jplus.mapper;

import org.jplus.pojo.masterCompartitionAndOther.YJSQTJX;
import org.springframework.stereotype.Repository;

/**
 * @author wb
 * @date 2019/11/8 - 10:15
 */
@Repository
public interface YJSQTJXMapper {
    void addYJSQTJX(YJSQTJX yJSQTJX);

    float getAllQtGzl();
}
