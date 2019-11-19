package org.jplus.mapper;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @description:审核本院工作量1持久层
 * @author:zmj
 * @date 2019/11/1618:44
 */
@Component
public interface CheckgzlMapper {
    //根据工号查院系
    String getYxByGh(String gh);

    //根据工号查教师基本信息，可获取工号，职务编码和额定工作量
    List<Map<String,Object>> getAllJbxx(String gh);

    //根据工号查询姓名
    List<String> getAllUname(List<String> gh);

    //根据职务编码查询职务
    List<String> getAllZw(List<Integer> zwbm);

    //根据工号查询所有本科生工作量总和
    List<Float> getBksSumGzl(List<String> gh);

    //根据工号查询所有研究生工作量总和
    List<Float> getYjsSumGzl(List<String> gh);

    //根据工号查询所有提交状态
    List<Integer> getAllTjzt(List<String> gh);

}
