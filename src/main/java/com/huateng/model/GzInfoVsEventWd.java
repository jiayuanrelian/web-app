package com.huateng.model;

public class GzInfoVsEventWd {
    private Long id;

    private Long infoId;

    private Long eventWdId;

    private String operator;

    private String opeValue;

    private Integer sortNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInfoId() {
        return infoId;
    }

    public void setInfoId(Long infoId) {
        this.infoId = infoId;
    }

    public Long getEventWdId() {
        return eventWdId;
    }

    public void setEventWdId(Long eventWdId) {
        this.eventWdId = eventWdId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getOpeValue() {
        return opeValue;
    }

    public void setOpeValue(String opeValue) {
        this.opeValue = opeValue == null ? null : opeValue.trim();
    }

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }
}