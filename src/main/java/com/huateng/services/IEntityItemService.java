package com.huateng.services;

import java.util.List;

import com.huateng.exception.BusinessException;
import com.huateng.model.EntityItem;

/**
 * 实体属性Service层
 * @author zhuenran
 *
 */
public interface IEntityItemService {

	public void saveEntityItem(EntityItem entityItem) throws BusinessException;
	
	public void deleteEntityItem(String[] ids);
	
	List<EntityItem> selectByPage(String field,String entityId,int pageIndex,int pageSize);
}
