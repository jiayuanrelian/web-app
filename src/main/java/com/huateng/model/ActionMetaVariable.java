package com.huateng.model;

import java.util.Date;
/**
 * 规则动作的参数
 * @author zhuenran
 *
 */
public class ActionMetaVariable {
    private Integer id;

    private String methodC;

    private String description;

    private Integer actionMetaId;

    private String delFlag;

    private Date dateCreated;

    private String createrId;

    private Date dateUpdated;

    private String updaterId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMethodC() {
        return methodC;
    }

    public void setMethodC(String methodC) {
        this.methodC = methodC == null ? null : methodC.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getActionMetaId() {
        return actionMetaId;
    }

    public void setActionMetaId(Integer actionMetaId) {
        this.actionMetaId = actionMetaId;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getCreaterId() {
        return createrId;
    }

    public void setCreaterId(String createrId) {
        this.createrId = createrId == null ? null : createrId.trim();
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getUpdaterId() {
        return updaterId;
    }

    public void setUpdaterId(String updaterId) {
        this.updaterId = updaterId == null ? null : updaterId.trim();
    }
}