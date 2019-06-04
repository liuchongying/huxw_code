package com.huxw.demo.entity;

import java.util.Date;

/**
 * @Author: huxw
 * @Date: 2019-4-2 20:50
 * @Version 1.0
 */
public class Plan {
    /**
     * 主键
     */
    private String fdId;
    /**
     * 计划名称
     */
    private String fdName;
    /**
     * 计划编号
     */
    private String fdPlanNo;
    /**
     * 是否发起长协
     */
    private String fdIsAsso;
    /**
     * 长协有效日期
     */
    private Date fdAssoDate;
    /**
     * 创建日期
     */
    private Date fdCreateDate;
    /**
     * 修改日期
     */
    private Date fdUpdateDate;

    public String getFdId() {
        return fdId;
    }

    public void setFdId(String fdId) {
        this.fdId = fdId;
    }

    public String getFdName() {
        return fdName;
    }

    public void setFdName(String fdName) {
        this.fdName = fdName;
    }

    public String getFdPlanNo() {
        return fdPlanNo;
    }

    public void setFdPlanNo(String fdPlanNo) {
        this.fdPlanNo = fdPlanNo;
    }

    public Date getFdAssoDate() {
        return fdAssoDate;
    }

    public void setFdAssoDate(Date fdAssoDate) {
        this.fdAssoDate = fdAssoDate;
    }

    public String getFdIsAsso() {
        return fdIsAsso;
    }

    public void setFdIsAsso(String fdIsAsso) {
        this.fdIsAsso = fdIsAsso;
    }

    public Date getFdCreateDate() {
        return fdCreateDate;
    }

    public void setFdCreateDate(Date fdCreateDate) {
        this.fdCreateDate = fdCreateDate;
    }

    public Date getFdUpdateDate() {
        return fdUpdateDate;
    }

    public void setFdUpdateDate(Date fdUpdateDate) {
        this.fdUpdateDate = fdUpdateDate;
    }
}
