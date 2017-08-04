package com.huateng.dao.mapper;

import com.huateng.model.GzEventWd;

public interface GzEventWdMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GzEventWd record);

    int insertSelective(GzEventWd record);

    GzEventWd selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GzEventWd record);

    int updateByPrimaryKey(GzEventWd record);
}