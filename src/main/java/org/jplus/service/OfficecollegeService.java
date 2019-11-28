package org.jplus.service;

import org.jplus.pojo.Tjzt.Tjb;
import org.jplus.pojo.basisInfo.Yxbm;
import org.jplus.pojo.checkgzl.Checkgzl;

import java.util.List;

/**
 * @description:审核本院工作量1服务层接口
 * @author:zmj
 * @date 2019/11/1618:21
 */
public interface OfficecollegeService {
    //获取院系名称
    String getYxmc(String gh);

    //获取院系编码
    Integer getYxbm(String gh);

    //获取统计信息通过工号
    List<Checkgzl> getCheckgzlInfByGh(String gh);

    //获取所有院系信息
    List<Yxbm> getAllYxbm();

    //获取统计信息通过院系
    List<Checkgzl> getCheckgzlInfByYxbm(Integer yxbm);
}
