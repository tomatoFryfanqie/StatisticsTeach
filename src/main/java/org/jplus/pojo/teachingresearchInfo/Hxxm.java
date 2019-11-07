package org.jplus.pojo.teachingresearchInfo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @description: 横向项目实体
 * @author:zmj
 * @date 2019/11/115:17
 */
@Data
public class Hxxm {
//横向项目id
    private Integer hxxmid;

//工号
    private String gh;

//年度
    private Integer nd;

//横向项目名称
    private String xmmc;

//到账经费
    private Integer dzjf;

//项目排名
    private Integer xmpm;

//项目总人数
    private Integer zrs;

//横向工作量
    private Float gzl;
}
