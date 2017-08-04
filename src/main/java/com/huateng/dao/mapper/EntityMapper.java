package com.huateng.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.huateng.model.Entity;

public interface EntityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Entity record);

    int insertSelective(Entity record);

    Entity selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Entity record);

    int updateByPrimaryKey(Entity record);
    
    /**
     * 通过标示查
     * @param identify
     * @return
     */
    int selectByIdentify(@Param("identify")String identify);
    /*
     * 分页条件查询
     */
    List<Entity> selectByPage(@Param("name")String name,@Param("start")int start,@Param("end")int end);
    /*
     * 分页查询总条数
     */
    int selectByPageCount(@Param("name")String name);
    /*
     * 批量删除
     */
    int deleteByBath(@Param("id")String id);
}