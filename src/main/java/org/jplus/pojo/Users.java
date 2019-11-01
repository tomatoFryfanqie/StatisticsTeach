package org.jplus.pojo;

/**
 * @author imlgw.top
 * @date 2019/10/31 17:18
 */
/*
* CREATE TABLE `users` (
  `gh` char(8) NOT NULL,
  `yxbm` int(10) DEFAULT NULL,
  `uname` varchar(20) DEFAULT NULL,
  `upassword` varchar(20) DEFAULT NULL,
  `actor` int(10) DEFAULT NULL,
  PRIMARY KEY (`gh`) USING BTREE,
  KEY `users_yxbm_fk` (`yxbm`) USING BTREE,
  CONSTRAINT `users_yxbm_fk` FOREIGN KEY (`yxbm`) REFERENCES `yxbm` (`yxbm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
* */
public class Users {
    //工号
    private String gh;
    //院系编码
    private int yxbm;
    //用户名
    private String uname;
    //密码
    private String upassword;
    //角色
    private int actor;

    @Override
    public String toString() {
        return "Users{" +
                "gh='" + gh + '\'' +
                ", yxbm=" + yxbm +
                ", uname='" + uname + '\'' +
                ", upassword='" + upassword + '\'' +
                ", actor=" + actor +
                '}';
    }

    public String getGh() {
        return gh;
    }

    public void setGh(String gh) {
        this.gh = gh;
    }

    public int getYxbm() {
        return yxbm;
    }

    public void setYxbm(int yxbm) {
        this.yxbm = yxbm;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public int getActor() {
        return actor;
    }

    public void setActor(int actor) {
        this.actor = actor;
    }
}
