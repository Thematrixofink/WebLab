package com.weblab.system.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 
 * </p>
 *
 * @author inkslab
 * @since 2023-04-12
 */
@ApiModel(value = "Users对象", description = "")
@AllArgsConstructor
@NoArgsConstructor
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    //用户名,学生的话为学号
    private String userName;
    //真实姓名
    private String realName;
    //密码
    private String password;
    //身份,0为学生,1为评委
    private Integer status;
    //是否是评委,0的话不是，1是，若status是1，那么自动为1
    private Integer ifJudges;
    //组号
    private Integer groupId;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIfJudges() {
        return ifJudges;
    }

    public void setIfJudges(Integer ifJudges) {
        this.ifJudges = ifJudges;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "Users{" +
            "userName = " + userName +
            ", realName = " + realName +
            ", password = " + password +
            ", status = " + status +
            ", ifJudges = " + ifJudges +
            ", groupId = " + groupId +
        "}";
    }
}
