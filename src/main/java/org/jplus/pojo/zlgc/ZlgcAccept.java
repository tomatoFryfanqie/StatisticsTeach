package org.jplus.pojo.zlgc;

import lombok.Data;

/**
 * @program: StatisticsTeach
 * @description: 接收用户页面输入的数据
 * @author: MH
 * @create: 2019-11-02 16:08
 **/
@Data
public class ZlgcAccept {
    //质量工程ID	zlgcid 系统自增
    private int zlgcid;
    //工号	gh char(8)
    private String gh;
    //年度	nd int
    private int nd;
    //项目类型编码	lxbm int
    private int xmlxbm;
    //项目名称	xmmc varchar(50)
    private String xmmc;
    //级别	jb int    1 国家级 2 省级
    private int jb;
    //项目排名	xmpm int
    private int xmpm;
    //项目总人数	zsr int
    private int xmzrs;
    //质量工程工作量	gzl float
    private float zlgcgzl;
}
