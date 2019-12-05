package org.jplus.pojo.zlgc;

import lombok.Data;


@Data
public class ZlgcAccept {
    //质量工程ID	zlgcid 系统自增
    private Integer zlgcid;
    //工号	gh char(8)
    private String gh;
    //年度	nd int
    private Integer nd;
    //项目类型编码	lxbm int
    private Integer xmlxbm;
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
