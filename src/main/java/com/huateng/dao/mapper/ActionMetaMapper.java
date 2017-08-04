package com.huateng.dao.mapper;

import com.huateng.model.ActionMeta;
/**
 * 规则动作接口
 * @author zhuenran
 *
 */
public interface ActionMetaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ActionMeta record);

    int insertSelective(ActionMeta record);

    ActionMeta selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ActionMeta record);

    int updateByPrimaryKey(ActionMeta record);
}