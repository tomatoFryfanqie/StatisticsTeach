package org.jplus.mapper;

import org.jplus.pojo.Tjzt.Tjzt;
import org.jplus.pojo.Users;
import org.jplus.pojo.basisInfo.Jbxx;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description:审核本院工作量1持久层
 * @author:zmj
 * @date 2019/11/1618:44
 */
@Component
public interface CheckgzlMapper {
    //根据工号查院系
    String getYxByGh(String gh);

    //查询该院系所有工号和姓名
    List<Users> getAllGhAndUname(String gh);

    //根据工号查教师基本信息，可获取职务编号和额定工作量
    Jbxx getAllJbxx(String gh);

    //根据职务编码查职务
    String getZwByZwbm(Integer zwbm);

    //根据工号查询本科生工作量总和
    Float getBksSumGzl(String gh);

    //根据工号查询研究生工作量总和
    Float getYjsSumGzl(String gh);

    //根据工号查询提交状态和审核状态
    Tjzt getTjztAndShzt(String gh);

}
