package org.jplus.pojo.bks;

/*
* CREATE TABLE `zylxbm` (
  `zylxbm` int(10) NOT NULL,
  `zylxmc` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`zylxbm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
* */
public class Zylxbm {
    private int zylxbm;
    private String zylxmc;

    public int getZylxbm() {
        return zylxbm;
    }

    public void setZylxbm(int zylxbm) {
        this.zylxbm = zylxbm;
    }

    public String getZylxmc() {
        return zylxmc;
    }

    public void setZylxmc(String zylxmc) {
        this.zylxmc = zylxmc;
    }
}
