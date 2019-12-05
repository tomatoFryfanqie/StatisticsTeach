package org.jplus.pojo.yjsktjx;

import lombok.Data;


@Data
public class Yjsktjx {
    /*研究生课堂教学自增id*/
    private Integer yjsktjx;
    /*工号*/
    private String gh;
    /*年度*/
    private Integer nd;
    /*学期*/
    private Integer xq;
    /*课程名称*/
    private String kcmc;
    /*课程类型编码*/
    private Yjskclx kclx;
    /*授课对象*/
    private String skdx;
    /*计划学时*/
    private Integer jhxs;
    /*上课人数*/
    private Integer skrs;
    /*研究生课堂教学工作量*/
    private Float gzl;
}
