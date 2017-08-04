package com.huateng.dao.mapper;

import java.util.List;

import com.huateng.model.Menu;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
    /*
     * 查询出所有的菜单列表
     */
    List<Menu> selectAllMenus();
    /*
     * 查询出所有Accordion菜单项
     */
    List<Menu> selectAllAccordionMenus();
    /*
     * 根据Accordion菜单的名称查找出对应的树菜单
     */
    List<Menu> selectChildMenus(String name);
}