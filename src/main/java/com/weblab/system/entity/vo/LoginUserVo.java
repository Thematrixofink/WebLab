package com.weblab.system.entity.vo;

public class LoginUserVo {
    private String username;
    private String password;
    private String identity;

    public LoginUserVo(String username, String password, String identity) {
        this.username = username;
        this.password = password;
        this.identity = identity;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getIdentity() {
        return identity;
    }
}
