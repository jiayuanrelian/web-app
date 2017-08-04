package com.huateng.dao.mapper;

import com.huateng.model.GzAction;

public interface GzActionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GzAction record);

    int insertSelective(GzAction record);

    GzAction selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GzAction record);

    int updateByPrimaryKey(GzAction record);
}