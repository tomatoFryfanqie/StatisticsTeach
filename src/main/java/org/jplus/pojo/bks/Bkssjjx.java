package org.jplus.pojo.bks;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**
 * @author imlgw.top
 * @date 2019/10/30 15:11
 */

/*
* `bkssjjxid` int(10) NOT NULL AUTO_INCREMENT,
  `gh` char(8) DEFAULT NULL,
  `nd` int(10) DEFAULT NULL,
  `sxlxbm1` int(10) DEFAULT NULL,
  `sxts1` int(10) DEFAULT NULL,
  `sxlxbm2` int(10) DEFAULT NULL,
  `sxts2` int(10) DEFAULT NULL,
  `sxlxbm3` int(10) DEFAULT NULL,
  `sxts3` int(10) DEFAULT NULL,
  `wgsjrs` int(10) DEFAULT NULL,
  `zylxbm` int(10) DEFAULT NULL,
  `zdlwrs` int(10) DEFAULT NULL,
  `glnr` varchar(255) DEFAULT NULL,
  `glgzl` float(10,0) DEFAULT NULL,
  `sjjxgzl` float(10,0) DEFAULT NULL,
 */
@Getter@Setter@ToString
public class Bkssjjx {
    //id
    private int bkssjjxid;
    //工号
    private String gh;
    //年度
    private int nd;
    //指导实习类型编码
    private int sxlxbm1;
    //指导实习天数
    private int sxts1;
    private int sxlxbm2;
    private int sxts2;
    private int sxlxbm3;
    private int sxts3;
    //微格试讲人数
    private int wgsjrs;
    //专业类型编码
    private int zylxbm;
    //指导论文人数
    private int zdlwrs;
    //管理内容
    private String glnr;
    //管理工作量
    private Float glgzl;
    //实践教学工作量
    private Float gzl;
}
