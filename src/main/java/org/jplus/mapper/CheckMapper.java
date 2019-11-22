package org.jplus.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.jplus.pojo.QTJXGZ;
import org.jplus.pojo.ZDXSLW;
import org.jplus.pojo.check.BkssjjxInfo;
import org.jplus.pojo.check.YjssjjxInfo;
import org.jplus.pojo.jbjsyxkjs.JBJSYXKJS;
import org.jplus.pojo.masterCompartitionAndOther.YJSQTJX;
import org.jplus.pojo.masterCompartitionAndOther.ZDSSLW;
import org.jplus.pojo.yjssjjx.Yjssjjx;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: StatisticsTeach
 * @description: 审核页面
 * @author: MH
 * @create: 2019-11-19 14:11
 **/
@Component
public interface CheckMapper {
    //根据院系编码，取出院系名称
    public String getLxmc(Integer yxbm);

    //根据工号取出其他教学工作信息  研究生 YJSQTJX
    public YJSQTJX getYJSQTJXInfo(String gh);

    // 指导学士论文 本科生 硕士论文 ZDSSLW
    public ZDSSLW getZDSSLWInfo(String gh);

    //根据工号，取出教学基本建设与学科建设 JBJSYXKJS
    public JBJSYXKJS getJBJSYXKJSInfo(String gh);


    // <!-- 根据工号取出其他教学工作信息  ,本科生 QTJXGZ-->
    public QTJXGZ getQTJXGZInfo(String gh);

    // <!-- 指导学士论文 本科生 学生论文 ZDXSLW-->
    public ZDXSLW getZDXSLWInfo(String gh);

    //根据工号，取出教学实践信息 practiceteh 本科生 BKSSJJX
    public BkssjjxInfo getBKSSJJXInfo(String gh);

    // <!-- 根据工号，取出教学实践信息 研究生 YJSSJJX-->
    public YjssjjxInfo getYJSSJJXInfo(String gh);



}
