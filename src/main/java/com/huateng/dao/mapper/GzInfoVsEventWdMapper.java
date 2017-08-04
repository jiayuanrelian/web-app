package com.huateng.dao.mapper;

import com.huateng.model.GzInfoVsEventWd;

public interface GzInfoVsEventWdMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GzInfoVsEventWd record);

    int insertSelective(GzInfoVsEventWd record);

    GzInfoVsEventWd selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GzInfoVsEventWd record);

    int updateByPrimaryKey(GzInfoVsEventWd record);
}