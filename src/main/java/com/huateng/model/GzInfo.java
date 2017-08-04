package com.huateng.model;

import java.util.Date;

public class GzInfo {
    private Long id;

    private String code;

    private String name;

    private String type;

    private String briefInfo;

    private String status;

    private Integer version;

    private Long refEventId;

    private Long refZcdId;

    private String delFlag;

    private Date pointValidate;

    private Date dateCreated;

    private String createrId;

    private Date dateUpdated;

    private String updaterId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getBriefInfo() {
        return briefInfo;
    }

    public void setBriefInfo(String briefInfo) {
        this.briefInfo = briefInfo == null ? null : briefInfo.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Long getRefEventId() {
        return refEventId;
    }

    public void setRefEventId(Long refEventId) {
        this.refEventId = refEventId;
    }

    public Long getRefZcdId() {
        return refZcdId;
    }

    public void setRefZcdId(Long refZcdId) {
        this.refZcdId = refZcdId;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public Date getPointValidate() {
        return pointValidate;
    }

    public void setPointValidate(Date pointValidate) {
        this.pointValidate = pointValidate;
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