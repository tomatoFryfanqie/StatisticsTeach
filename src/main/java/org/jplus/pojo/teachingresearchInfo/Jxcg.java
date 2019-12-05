package org.jplus.pojo.teachingresearchInfo;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class Jxcg {
// 教学成果ID
    private Integer jxcgid;

//工号
    private String gh;

//年度
    private Integer nd;

//成果名称
    private String cgmc;


//成果等级编码
    private Integer cgdjbm;


//项目排名
    private Integer xmpm;


//项目总人数
    private Integer zrs;

//教学成果工作量
    private Float gzl;
}
