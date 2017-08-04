package com.huateng.model;

import java.util.Date;

public class GzEventWd {
    private Long id;

    private String code;

    private String name;

    private String status;

    private String type;

    private String typeKey;

    private Long refEventId;

    private String isCounter;

    private Long refCounterId;

    private String delFlag;

    private Date dateCreated;

    private String createrId;

    private Date dateUpdated;

    private String updaterId;

    private String isPublic;

    private String publicType;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getTypeKey() {
        return typeKey;
    }

    public void setTypeKey(String typeKey) {
        this.typeKey = typeKey == null ? null : typeKey.trim();
    }

    public Long getRefEventId() {
        return refEventId;
    }

    public void setRefEventId(Long refEventId) {
        this.refEventId = refEventId;
    }

    public String getIsCounter() {
        return isCounter;
    }

    public void setIsCounter(String isCounter) {
        this.isCounter = isCounter == null ? null : isCounter.trim();
    }

    public Long getRefCounterId() {
        return refCounterId;
    }

    public void setRefCounterId(Long refCounterId) {
        this.refCounterId = refCounterId;
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

    public String getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(String isPublic) {
        this.isPublic = isPublic == null ? null : isPublic.trim();
    }

    public String getPublicType() {
        return publicType;
    }

    public void setPublicType(String publicType) {
        this.publicType = publicType == null ? null : publicType.trim();
    }
}