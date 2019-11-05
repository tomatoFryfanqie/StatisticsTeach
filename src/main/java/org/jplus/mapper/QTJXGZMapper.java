package org.jplus.mapper;

import org.jplus.pojo.QTJXGZ;
import org.springframework.stereotype.Repository;

/**
 * @author wb
 * @date 2019/11/1 - 14:18
 */
@Repository
public interface QTJXGZMapper {

    void addQTJXGZ(QTJXGZ qTJXGZ);

    float getAllQtGzl();
}
