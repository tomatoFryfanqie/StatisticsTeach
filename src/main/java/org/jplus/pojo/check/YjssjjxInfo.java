package org.jplus.pojo.check;

import lombok.Data;


@Data
public class YjssjjxInfo {
    /*研究生实践教学id*/
    private Integer yjssjjx;
    /*工号*/
    private String gh;
    /*年度*/
    private Integer nd;
    /*实践类型编码1*/
    private Yjssxlxbm yjssxlxbm1;
    private Yjssxlxbm yjssxlxbm2;
    private Yjssxlxbm yjssxlxbm3;
    /*实践天数*/
    private Integer sjts1;
    /*实践天数*/
    private Integer sjts2;
    /*实践天数*/
    private Integer sjts3;

    /*指导学术活动次数*/
    private Integer zdxshdcs;
    /*日常工作说明*/
    private String rcgzsm;
    /*日常工作量*/
    private Float rcgzl;
    /*实践工作量*/
    private Float gzl;
}
