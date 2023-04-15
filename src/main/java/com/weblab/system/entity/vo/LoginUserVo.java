package com.weblab.system.entity.vo;

import lombok.Data;

@Data
public class LoginUserVo {
    private String username;
    private String password;
    private String identity;
    private Integer ifJudges;
}
