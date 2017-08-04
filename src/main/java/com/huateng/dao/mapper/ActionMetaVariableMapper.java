package com.huateng.dao.mapper;

import com.huateng.model.ActionMetaVariable;
/**
 * 规则动作接口对应的接口参数
 * @author zhuenran
 *
 */
public interface ActionMetaVariableMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ActionMetaVariable record);

    int insertSelective(ActionMetaVariable record);

    ActionMetaVariable selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ActionMetaVariable record);

    int updateByPrimaryKey(ActionMetaVariable record);
}