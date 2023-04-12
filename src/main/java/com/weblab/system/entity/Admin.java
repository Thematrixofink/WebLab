package com.weblab.system.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
    private String name;

    //管理员的密码
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
