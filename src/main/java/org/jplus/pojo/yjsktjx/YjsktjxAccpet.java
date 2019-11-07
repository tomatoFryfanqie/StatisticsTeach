package org.jplus.pojo.yjsktjx;

import lombok.Data;

/**
 * @BelongsProject: StatisticsTeach
 * @BelongsPackage: org.jplus.pojo.yjsktjx
 * @Author: lzh
 * @CreateTime: 2019/11/6
 * @Description: Description
 */
@Data
public class YjsktjxAccpet {
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
    private Integer kclx;
    /*授课对象*/
    private String skdx;
    /*计划学时*/
    private Integer jhxs;
    /*上课人数*/
    private Integer skrs;
    /*研究生课堂教学工作量*/
    private Float gzl;
}
