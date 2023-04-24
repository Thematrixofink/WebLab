package com.weblab.system.entity.vo;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginUserVo {
    @NotBlank(message = "用户名不能为空！")
    private String username;
    @NotBlank(message = "密码不能为空！")
    private String password;
    private String identity;

    private Integer ifJudges;
}
