package org.jplus.dto;

import javax.validation.constraints.NotBlank;


public class LoginVo {
    @NotBlank
    private String gh;
    @NotBlank
    private String password;

    @Override
    public String toString() {
        return "LoginVo{" +
                "gh='" + gh + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getGh() {
        return gh;
    }

    public void setGh(String gh) {
        this.gh = gh;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
