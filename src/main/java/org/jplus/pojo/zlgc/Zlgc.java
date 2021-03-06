package org.jplus.pojo.zlgc;

import lombok.Data;


/*
  `zlgcid` int(10) NOT NULL AUTO_INCREMENT,
  `gh` char(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nd` int(10) NULL DEFAULT NULL,
  `xmlxbm` int(10) NULL DEFAULT NULL,
  `xmmc` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `jb` int(10) NULL DEFAULT NULL,
  `xmpm` int(10) NULL DEFAULT NULL,
  `zrs` int(10) NULL DEFAULT NULL,
  `gzl` float(10, 0) NULL DEFAULT NULL,
*/
@Data
public class Zlgc {
    //质量工程ID	zlgcid 系统自增
    private Integer zlgcid;
    //工号	gh char(8)
    private String gh;
    //年度	nd int
    private Integer nd;
    //项目类型编码	lxbm int
    private Zlgcxmlx zlgcxmlx;
    //项目名称	xmmc varchar(50)
    private String xmmc;
    //级别	jb int    1 国家级 2 省级
    private Integer jb;
    //项目排名	xmpm int
    private Integer xmpm;
    //项目总人数	zsr int
    private Integer zrs;
    //质量工程工作量	gzl float
    private Float gzl;
}
