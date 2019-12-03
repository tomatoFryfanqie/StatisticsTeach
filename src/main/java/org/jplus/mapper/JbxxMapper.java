package org.jplus.mapper;

import org.jplus.pojo.basisInfo.*;

import java.util.List;

/**
 * @BelongsProject: StatisticsTeach
 * @BelongsPackage: org.jplus.mapper
 * @Author: lzh
 * @CreateTime: 2019/10/31
 * @Description: Description
 */
public interface JbxxMapper {
    Jbxx getJbxxInfo(String gh);

    List<Yxbm> getYxbmInfo();

    List<Zwbm> getZwbmInfo();

    List<Zcbm> getZcbmInfo();

    List<Gwlxbm> getGwlxbmInfo();

    void updateBasisInfo(JbxxAccpet jbxxAccpet);

    void addJbxx(String gh);


    Float getBksKtjxgzl(String gh);

    Float getBksSjjxgzl(String gh);

    Float getBksZlgcgzl(String gh);

    Float getZdxsgzl(String gh);

    Float getJsjsgzl(String gh);

    Float getLwgzl(String gh);

    Float getQtgzl(String gh);

    Float getYjsSjjxgzl(String gh);

    Float getJsgzl(String gh);

    Float getYjsZdgzl(String gh);

    Float getYjsQtgzl(String gh);
}
