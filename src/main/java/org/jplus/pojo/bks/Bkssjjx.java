package org.jplus.pojo.bks;
import java.math.BigDecimal;

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
    private BigDecimal glgzl;
    //实践教学工作量
    private BigDecimal sjjxgzl;

    public int getBkssjjxid() {
        return bkssjjxid;
    }

    public void setBkssjjxid(int bkssjjxid) {
        this.bkssjjxid = bkssjjxid;
    }

    public String getGh() {
        return gh;
    }

    public void setGh(String gh) {
        this.gh = gh;
    }

    public int getNd() {
        return nd;
    }

    public void setNd(int nd) {
        this.nd = nd;
    }

    public int getSxlxbm1() {
        return sxlxbm1;
    }

    public void setSxlxbm1(int sxlxbm1) {
        this.sxlxbm1 = sxlxbm1;
    }

    public int getSxts1() {
        return sxts1;
    }

    public void setSxts1(int sxts1) {
        this.sxts1 = sxts1;
    }

    public int getSxlxbm2() {
        return sxlxbm2;
    }

    public void setSxlxbm2(int sxlxbm2) {
        this.sxlxbm2 = sxlxbm2;
    }

    public int getSxts2() {
        return sxts2;
    }

    public void setSxts2(int sxts2) {
        this.sxts2 = sxts2;
    }

    public int getSxlxbm3() {
        return sxlxbm3;
    }

    public void setSxlxbm3(int sxlxbm3) {
        this.sxlxbm3 = sxlxbm3;
    }

    public int getSxts3() {
        return sxts3;
    }

    public void setSxts3(int sxts3) {
        this.sxts3 = sxts3;
    }

    public int getWgsjrs() {
        return wgsjrs;
    }

    public void setWgsjrs(int wgsjrs) {
        this.wgsjrs = wgsjrs;
    }

    public int getZylxbm() {
        return zylxbm;
    }

    public void setZylxbm(int zylxbm) {
        this.zylxbm = zylxbm;
    }

    public int getZdlwrs() {
        return zdlwrs;
    }

    public void setZdlwrs(int zdlwrs) {
        this.zdlwrs = zdlwrs;
    }

    public String getGlnr() {
        return glnr;
    }

    public void setGlnr(String glnr) {
        this.glnr = glnr;
    }

    public BigDecimal getGlgzl() {
        return glgzl;
    }

    public void setGlgzl(BigDecimal glgzl) {
        this.glgzl = glgzl;
    }

    public BigDecimal getSjjxgzl() {
        return sjjxgzl;
    }

    public void setSjjxgzl(BigDecimal sjjxgzl) {
        this.sjjxgzl = sjjxgzl;
    }
}
