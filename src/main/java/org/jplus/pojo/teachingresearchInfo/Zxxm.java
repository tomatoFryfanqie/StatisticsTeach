package org.jplus.pojo.teachingresearchInfo;

import lombok.Data;

import java.math.BigDecimal;


@Data
public class Zxxm {
//纵向项目id
    private Integer zxxmid;

//工号
    private String gh;

//年度
    private Integer nd;

//项目名称
    private String xmmc;

//项目等级编码
    private Integer xmdjbm;

//项目排名
    private Integer xmpm;

//项目总人数
    private Integer zrs;

//纵向项目工作量
    private Float gzl;
}
