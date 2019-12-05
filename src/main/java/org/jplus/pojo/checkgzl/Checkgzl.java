package org.jplus.pojo.checkgzl;

import lombok.Data;


@Data
public class Checkgzl {
    //工号
    private String gh;

    //姓名
    private String uname;

    //职务
    private String zwmc;

    //额定工作量
    private Float edgzl;

    //本科生教学工作量
    private Float bkszgzl;

    //研究生教学工作量
    private Float yjszgzl;

    //审核状态
    private Integer shzt;

    //提交状态
    private Integer tjzt;
}
