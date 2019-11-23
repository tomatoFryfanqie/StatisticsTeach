package org.jplus.pojo.check;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: StatisticsTeach
 * @description: 实践教学数据库实体类
 * @author: MH
 * @create: 2019-11-19 19:22
 **/
@Data
public class BkssjjxInfo {
    private Integer bkssjjxid;
    private String gh;
    private Integer nd;
    private Sxlx sxlx1;
    private Integer sxts1;
    private Sxlx sxlx2;
    private Integer sxts2;
    private Sxlx sxlx3;
    private Integer sxts3;
    //微格试讲人数
    private Integer wgsjrs;
    //专业类型编码
    private Zylxbm zylxbm;
    //指导论文人数
    private Integer zdlwrs;
    //管理内容
    private String glnr;
    //管理工作量
    private Float glgzl;
    //实践教学工作量
    private Float gzl;
}
