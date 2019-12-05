package org.jplus.pojo.yjsktjx;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


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
    @NotBlank(message = "课程名称不能为空")
    private String kcmc;
    /*课程类型编码*/
    private Integer kclx;
    /*授课对象*/
    @NotBlank(message = "授课对象不能为空")
    private String skdx;
    /*计划学时*/
    @NotNull(message = "计划学时不能为空")
    @Max(value = 1000,message = "请输入合适的计划学时")
    private Integer jhxs;
    /*上课人数*/
    @NotNull(message = "上课人数不能为空")
    @Max(value = 1000,message = "请输入合适的授课人数")
    private Integer skrs;
    /*研究生课堂教学工作量*/
    private Float gzl;
}
