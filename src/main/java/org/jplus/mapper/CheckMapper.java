package org.jplus.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.jplus.pojo.undergraduateCompatitonAndOther.QTJXGZ;
import org.jplus.pojo.undergraduateCompatitonAndOther.ZDXSLW;
import org.jplus.pojo.check.BkssjjxInfo;
import org.jplus.pojo.check.YjssjjxInfo;
import org.jplus.pojo.jbjsyxkjs.JBJSYXKJS;
import org.jplus.pojo.masterCompartitionAndOther.YJSQTJX;
import org.jplus.pojo.masterCompartitionAndOther.ZDSSLW;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;


@Component
public interface CheckMapper {


    public String getLxmcByGh(String gh);

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

    // <!--教师竞赛工作量-->
    public Float getJsjsGzl(String gh);

    // <!--本科 学生竞赛工作量-->
    public Float getZdxsjsGzl(String gh);


    // <!--研究生 学生竞赛工作量-->
    public Float getYjsZdxsjsGzl(String gh);

    //<!--撤回提交状态 撤回审核状态-->
    public void clearTjztAndShzt(String gh);

    //<!--院系  更新审核状态为1 -->
    @Update("update `tjzt` set shzt = 2, yxshrxm =#{username} , yxshsj = #{date}  where gh=#{gh}")
    public void setShztByDepartments(@Param("gh") String gh,@Param("username") String userName,@Param("date") Timestamp date);

    //<!--教务处 更新审核状态为2 -->
    @Update("update `tjzt` set shzt = 3, jwcshrxm =#{username} , jwcshsj = #{date}  where gh=#{gh}")
    public void setShztByOffice(@Param("gh") String gh,@Param("username") String userName,@Param("date") Timestamp date);

    //<!--院系 更新审核人姓名到提交表 -->
    @Update("update tjb set shrgh=#{shrgh} where gh=#{gh}")
    public void setShrgh(@Param("gh")String gh, @Param("shrgh")String shrgh);

}
