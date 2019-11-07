package org.jplus.pojo.teachingresearchInfo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @description: 教学改革实体类
 * @author:zmj
 * @date 2019/11/115:39
 */
@Data
public class Jxgg {
//教学改革id
    private Integer jxggid;

//工号
    private String gh;

//年度
    private Integer nd;

//项目名称
    private String xmmc;

//立项级别编码
    private Integer lxjbbm;

//项目排名
    private Integer xmpm;

//教学改革总人数
    private Integer zrs;

//教学改革工作量
    private Float gzl;
}
