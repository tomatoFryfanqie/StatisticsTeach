package org.jplus.pojo.classTeach;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
public class BksktjxAccpet {
    /*本科生教学课堂id*/
    private Integer bksktjx;
    /*教师工号*/
    private String gh;
    /*学年*/
    private Integer nd;
    /*学期*/
    private Integer xq;
    /*课堂名称*/
    @NotBlank(message = "课程名称不能为空")
    private String kcmc;
    /*课堂类型*/
    private Integer ktlxbm;
    /*授课班级*/
    @NotBlank(message = "授课班级不能为空")
    private String skbj;
    /*是否双语*/
    private Integer sfsy;
    /*计划学时*/
    @NotNull(message = "计划学时不能为空")
    @Max(value = 1000,message = "请输入合适的计划学时")
    private Integer jhxs;
    /*上课人数*/
    @NotNull(message = "上课人数不能为空")
    @Max(value = 1000,message = "请输入合适的授课人数")
    private Integer skrs;
    /*课堂工作量*/
    private Float jxgzl;
}
