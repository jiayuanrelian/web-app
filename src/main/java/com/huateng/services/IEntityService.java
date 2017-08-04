package com.huateng.services;

import java.util.List;

import com.huateng.exception.BusinessException;
import com.huateng.model.Entity;

public interface IEntityService {

	List<Entity> selectByPage(String name,int pageIndex,int pageSize);
	
	int saveEntity(Entity entity) throws BusinessException;
	
	int selectByPageCount(String name);
	
	void deleteByBath(String[] ids);
}
