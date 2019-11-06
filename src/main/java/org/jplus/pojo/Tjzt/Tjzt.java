package org.jplus.pojo.Tjzt;

import lombok.Data;

import java.util.Date;

/**
 * @BelongsProject: StatisticsTeach
 * @BelongsPackage: org.jplus.pojo
 * @Author: lzh
 * @CreateTime: 2019/11/6
 * @Description: Description
 */
@Data
public class Tjzt {
    /*提交状态id*/
    private Integer tijzid;
    /*工号*/
    private String gh;
    /*提交状态*/
    private Integer tjzt;
    /*提交时间*/
    private Date tjsj;
    /*审核状态*/
    private Integer shzt;
    /*教研室审核人姓名*/
    private String jysshrxm;
    /*教研室审核时间*/
    private Date jysshsj;
    /*院系审核人姓名*/
    private String yxshrxm;
    /*院系审核人时间*/
    private Date yxshsj;
    /*教务处审核人姓名*/
    private String ywcshrxm;
    /*教务处审核时间*/
    private Date jwcshsj;

}
