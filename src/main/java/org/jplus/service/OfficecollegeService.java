package org.jplus.service;

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

    //获取统计信息
    List<Checkgzl> getCheckgzlInf(String gh);

}
