package com.huateng.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huateng.model.EntityItem;

public interface EntityItemMapper {
    int deleteByPrimaryKey(Integer id);

    //int insert(EntityItem record);

    int insertSelective(EntityItem record);
    /**
     * 通过field,typeId查询是否有标示重复的记录
     * @param field
     * @return
     */
    int selectByIdentify(@Param("field")String field,@Param("typeId")Integer typeId);
    /**
     * 批量删除实体属性
     * @param ids
     * @return
     */
    int deleteEntityItem(@Param("id")String id);
    /**
     * 实体属性的分页查询
     * @param name
     * @param start
     * @param end
     * @return
     */
    List<EntityItem> selectByPage(@Param("field")String field,@Param("entityId")String entityId,@Param("start")int start,@Param("end")int end);

    EntityItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EntityItem record);

    int updateByPrimaryKey(EntityItem record);
}