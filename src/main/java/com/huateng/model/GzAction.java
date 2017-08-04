package com.huateng.model;

import java.util.Date;

public class GzAction {
    private Long id;

    private Long refChildProductId;

    private Long refGzInfoId;

    private Long refWdId;

    private Integer pointRate;

    private Integer pointBase;

    private String reason;

    private String status;

    private String delFlag;

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

    public Long getRefChildProductId() {
        return refChildProductId;
    }

    public void setRefChildProductId(Long refChildProductId) {
        this.refChildProductId = refChildProductId;
    }

    public Long getRefGzInfoId() {
        return refGzInfoId;
    }

    public void setRefGzInfoId(Long refGzInfoId) {
        this.refGzInfoId = refGzInfoId;
    }

    public Long getRefWdId() {
        return refWdId;
    }

    public void setRefWdId(Long refWdId) {
        this.refWdId = refWdId;
    }

    public Integer getPointRate() {
        return pointRate;
    }

    public void setPointRate(Integer pointRate) {
        this.pointRate = pointRate;
    }

    public Integer getPointBase() {
        return pointBase;
    }

    public void setPointBase(Integer pointBase) {
        this.pointBase = pointBase;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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