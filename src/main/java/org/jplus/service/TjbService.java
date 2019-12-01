package org.jplus.service;

import org.jplus.pojo.Tjzt.Tjb;

import java.util.List;

/**
 * @BelongsProject: StatisticsTeach
 * @BelongsPackage: org.jplus.service
 * @Author: lzh
 * @CreateTime: 2019/11/26
 * @Description: Description
 */
public interface TjbService {
    // MH 添加
    Tjb getTjbByGh(String gh);

    List<Tjb> getAllTjb();
}
