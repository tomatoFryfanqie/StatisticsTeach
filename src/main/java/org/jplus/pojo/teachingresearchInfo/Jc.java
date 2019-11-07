package org.jplus.pojo.teachingresearchInfo;


import lombok.Data;

import java.math.BigDecimal;

/**
 * @description: 教材实体类
 * @author:zmj
 * @date 2019/11/115:29
 */
@Data
public class Jc {
//教材id
    private Integer jcid;

//工号
    private String gh;

//年度
    private Integer nd;

//教材名称
    private String jcmc;

//教材等级编码
    private Integer jcjbbm;

//项目排名
    private Integer xmpm;

//项目总人数
    private Integer zrs;

//教材工作量
    private Float gzl;

}
