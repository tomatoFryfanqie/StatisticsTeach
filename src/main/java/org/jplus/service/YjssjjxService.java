package org.jplus.service;

import org.jplus.pojo.yjssjjx.Yjssjjx;
import org.jplus.pojo.yjssjjx.Yjssxlxbm;

import java.util.List;

/**
 * @BelongsProject: StatisticsTeach
 * @BelongsPackage: org.jplus.service
 * @Author: lzh
 * @CreateTime: 2019/11/7
 * @Description: Description
 */
public interface YjssjjxService {
    List<Yjssxlxbm> getSjlx();

    Yjssjjx getYjssjjxJbxx(String gh);
}
