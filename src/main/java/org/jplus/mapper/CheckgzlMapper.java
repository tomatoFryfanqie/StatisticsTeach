package org.jplus.mapper;

import org.jplus.pojo.basisInfo.Yxbm;
import org.jplus.pojo.checkgzl.Checkgzl;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description:审核本院和各院工作量1持久层
 * @author:zmj
 * @date 2019/11/1618:44
 */
@Component
public interface CheckgzlMapper {
    //根据工号查院系
    String getYxByGh(String gh);

    //根据工号查院系编码
    Integer getYxbmByGh(String gh);

    //查一个院系的数据根据工号
    List<Checkgzl> getCheckgzlInfByGh(String gh);

    //查询所有院系和院系编码
    List<Yxbm> getAllYxbm();

    //查一个院系的数据根据院系编码
    List<Checkgzl> getCheckgzlInfByYxbm(Integer yxbm);

    //查询所有院系数据
    List<Checkgzl> getAllCheckgzlInf();

}
