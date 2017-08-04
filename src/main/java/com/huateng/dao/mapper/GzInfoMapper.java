package com.huateng.dao.mapper;

import com.huateng.model.GzInfo;

public interface GzInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GzInfo record);

    int insertSelective(GzInfo record);

    GzInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GzInfo record);

    int updateByPrimaryKey(GzInfo record);
}