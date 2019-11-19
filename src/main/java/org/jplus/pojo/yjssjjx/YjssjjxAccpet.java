package org.jplus.pojo.yjssjjx;

import lombok.Data;

/**
 * @BelongsProject: StatisticsTeach
 * @BelongsPackage: org.jplus.pojo.yjssjjx
 * @Author: lzh
 * @CreateTime: 2019/11/7
 * @Description: Description
 */
@Data
public class YjssjjxAccpet {

    /*研究生实践教学id*/
    private Integer yjssjjx;
    /*工号*/
    private String gh;
    /*年度*/
    private Integer nd;
    /*实践类型编码1*/
    private Integer sjlxbm1;
    /*实践天数*/
    private Integer sjts1;
    /*实践类型编码2*/
    private Integer sjlxbm2;
    /*实践天数*/
    private Integer sjts2;
    /*实践类型编码3*/
    private Integer sjlxbm3;
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
