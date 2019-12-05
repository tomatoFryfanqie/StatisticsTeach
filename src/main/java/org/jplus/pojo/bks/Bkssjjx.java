package org.jplus.pojo.bks;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Min;


/*
* `bkssjjxid` Integer(10) NOT NULL AUTO_INCREMENT,
  `gh` char(8) DEFAULT NULL,
  `nd` Integer(10) DEFAULT NULL,
  `sxlxbm1` Integer(10) DEFAULT NULL,
  `sxts1` Integer(10) DEFAULT NULL,
  `sxlxbm2` Integer(10) DEFAULT NULL,
  `sxts2` Integer(10) DEFAULT NULL,
  `sxlxbm3` Integer(10) DEFAULT NULL,
  `sxts3` Integer(10) DEFAULT NULL,
  `wgsjrs` Integer(10) DEFAULT NULL,
  `zylxbm` Integer(10) DEFAULT NULL,
  `zdlwrs` Integer(10) DEFAULT NULL,
  `glnr` varchar(255) DEFAULT NULL,
  `glgzl` float(10,0) DEFAULT NULL,
  `sjjxgzl` float(10,0) DEFAULT NULL,
 */
@Getter@Setter@ToString
public class Bkssjjx {
    //id
    private Integer bkssjjxid;
    //工号
    private String gh;
    //年度
    private Integer nd;
    //指导实习类型编码
    private Integer sxlxbm1;
    //指导实习天数
    private Integer sxts1=0;

    private Integer sxlxbm2;

    private Integer sxts2=0;

    private Integer sxlxbm3;

    private Integer sxts3=0;

    //微格试讲人数
    private Integer wgsjrs;

    //专业类型编码
    private Integer zylxbm;

    //指导论文人数
    private Integer zdlwrs;
    //管理内容
    private String glnr;
    //管理工作量
    private Float glgzl;

    //实践教学工作量
    private Float gzl;
}
