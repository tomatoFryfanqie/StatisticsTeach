package org.jplus.pojo.yjsjyxm;

import lombok.Data;

/**
 * @description:研究生横向项目实体类
 * @author:zmj
 * @date 2019/11/816:13
 */
@Data
public class Yjshxxm {
//研究生横向项目id
    private Integer hxxmid;

//研究生横向项目工号
    private String gh;

//研究生横向项目年度
    private Integer nd;

//研究生横向项目名称
    private String xmmc;

//到账经费
    private Integer dzjf;

//项目排名
    private Integer xmpm;

//项目总人数
    private Integer zrs;

//项目工作量
    private Float gzl;

}
