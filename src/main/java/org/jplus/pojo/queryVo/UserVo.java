package org.jplus.pojo.queryVo;

/**
 * @author wb
 * @date 2019/11/26 - 18:56
 */
public class UserVo {
    //工号
    private String gh;
    //院系编码
    private Integer yxbm;
    // 院系名称
    private String ysname;
    //用户名
    private String uname;
    //密码
    private String upassword;
    //角色
    private Integer actor;
    // 角色名称
    private String acterName;

    public String getGh() {
        return gh;
    }

    public void setGh(String gh) {
        this.gh = gh;
    }

    public Integer getYxbm() {
        return yxbm;
    }

    public void setYxbm(Integer yxbm) {
        this.yxbm = yxbm;
    }

    public String getYsname() {
        return ysname;
    }

    public void setYsname(String ysname) {
        this.ysname = ysname;
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

    public Integer getActor() {
        return actor;
    }

    public void setActor(Integer actor) {
        this.actor = actor;
    }

    public String getActerName() {
        return acterName;
    }

    public void setActerName(String acterName) {
        this.acterName = acterName;
    }
}
