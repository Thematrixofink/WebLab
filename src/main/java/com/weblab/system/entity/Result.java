package com.weblab.system.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotBlank;

/**
 * <p>
 * 
 * </p>
 *
 * @author inkslab
 * @since 2023-04-12
 */
@ApiModel(value = "Result对象", description = "")
public class Result implements Serializable {

    private static final long serialVersionUID = 1L;

    //组号
    @NotBlank(message = "组号不能为空！")
    private Integer groupId;
    //评委姓名
    @NotBlank(message = "评委姓名不能为空！")
    private String judgesName;
    //总成绩
    @NotBlank(message = "总成绩不能为空！")
    private double score;
    //工作量成绩
    @NotBlank(message = "分工成绩不能为空！")
    private double workScore;
    //完成度成绩
    @NotBlank(message = "完成度成绩不能为空！")
    private double cmtScore;
    //界面设计
    @NotBlank(message = "界面设计成绩不能为空！")
    private double uiScore;
    //分工设计
    @NotBlank(message = "分工成绩不能为空！")
    private double divScore;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getJudgesName() {
        return judgesName;
    }

    public void setJudgesName(String judgesName) {
        this.judgesName = judgesName;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getWorkScore() {
        return workScore;
    }

    public void setWorkScore(double workScore) {
        this.workScore = workScore;
    }

    public double getCmtScore() {
        return cmtScore;
    }

    public void setCmtScore(double cmtScore) {
        this.cmtScore = cmtScore;
    }

    public double getUiScore() {
        return uiScore;
    }

    public void setUiScore(double uiScore) {
        this.uiScore = uiScore;
    }

    public double getDivScore() {
        return divScore;
    }

    public void setDivScore(double divScore) {
        this.divScore = divScore;
    }

    @Override
    public String toString() {
        return "Result{" +
            "groupId = " + groupId +
            ", judgesName = " + judgesName +
            ", score = " + score +
            ", workScore = " + workScore +
            ", cmtScore = " + cmtScore +
            ", uiScore = " + uiScore +
            ", divScore = " + divScore +
        "}";
    }
}
