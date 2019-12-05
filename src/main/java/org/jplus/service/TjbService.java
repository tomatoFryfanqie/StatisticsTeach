package org.jplus.service;

import org.jplus.pojo.Tjzt.Tjb;

import java.util.List;


public interface TjbService {
    // MH 添加
    Tjb getTjbByGh(String gh);

    List<Tjb> getAllTjb();

    List<Tjb> getAllTjbByYxbm(Integer yxbm);
}
