package org.jplus.pojo.classTeach;

import lombok.Data;


@Data
public class Bksktjx {

    /*本科生教学课堂id*/
    private Integer bksktjx;
    /*教师工号*/
    private String gh;
    /*学年*/
    private Integer nd;
    /*学期*/
    private Integer xq;
    /*课堂名称*/
    private String kcmc;
    /*课堂类型*/
    private Kclx kclx;
    /*授课搬家*/
    private String skbj;
    /*是否双语*/
    private Integer sfsy;
    /*计划学时*/
    private Integer jhxs;
    /*上课人数*/
    private Integer skrs;
    /*课堂工作量*/
    private Float jxgzl;
}
