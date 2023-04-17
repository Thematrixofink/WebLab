package com.weblab.system.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

/**
 * <p>
 * 
 * </p>
 *
 * @author inkslab
 * @since 2023-04-12
 */
@ApiModel(value = "Admin对象", description = "")
public class Admin implements Serializable {


    private static final long serialVersionUID = 1L;

    //管理员的姓名
    @NotBlank(message = "管理员用户名不能为空")
    private String name;

    //管理员的密码
    @NotBlank(message = "密码不能为空")
    @Length(min = 6,message = "密码长度至少6位")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
            "name = " + name +
            ", password = " + password +
        "}";
    }
}
