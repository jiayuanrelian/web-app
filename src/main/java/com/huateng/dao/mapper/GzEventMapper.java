package com.huateng.dao.mapper;

import com.huateng.model.GzEvent;

public interface GzEventMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GzEvent record);

    int insertSelective(GzEvent record);

    GzEvent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GzEvent record);

    int updateByPrimaryKey(GzEvent record);
}