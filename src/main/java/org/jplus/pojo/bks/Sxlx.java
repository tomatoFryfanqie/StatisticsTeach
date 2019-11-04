package org.jplus.pojo.bks;

import lombok.Data;

/**
 * @author imlgw.top
 * @date 2019/11/1 15:57
 */
/*
* CREATE TABLE `sxlx` (
  `sxlxbm` int(10) NOT NULL,
  `sxlxmc` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`sxlxbm`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
* */
public class Sxlx {
    private int sxlxbm;
    private String sxlxmc;

    public Sxlx(int sxlxbm, String sxlxmc) {
        this.sxlxbm = sxlxbm;
        this.sxlxmc = sxlxmc;
    }

    public int getSxlxbm() {
        return sxlxbm;
    }

    public void setSxlxbm(int sxlxbm) {
        this.sxlxbm = sxlxbm;
    }

    public String getSxlxmc() {
        return sxlxmc;
    }

    public void setSxlxmc(String sxlxmc) {
        this.sxlxmc = sxlxmc;
    }
}
