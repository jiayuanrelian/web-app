package com.huateng.dao.mapper;

import org.apache.ibatis.annotations.Param;

import com.huateng.model.Student;

public interface StudentMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    /*
     * 通过用户名及密码校验用户是否存在
     */
	Student isExsit(String name, String password);
}