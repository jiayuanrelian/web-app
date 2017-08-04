package com.huateng.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.dao.mapper.EntityItemMapper;
import com.huateng.exception.BusinessException;
import com.huateng.exception.errorcode.LuoErrorCode;
import com.huateng.model.EntityItem;
import com.huateng.services.IEntityItemService;
@Service
public class EntityItemServiceImpl implements IEntityItemService{

	@Autowired
	private EntityItemMapper entityItemMapper;
	@Override
	@Transactional(readOnly=false,isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void saveEntityItem(EntityItem entityItem) throws BusinessException {
		int count = entityItemMapper.selectByIdentify(entityItem.getField(),entityItem.getTypeId());
		if (count > 0) {
			throw new BusinessException(LuoErrorCode.NOT_REPEAT.getDesc());
		}
		entityItemMapper.insertSelective(entityItem);
	}
	
	@Override
	@Transactional(readOnly=false,isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void deleteEntityItem(String[] ids) {
			for (int i = 0; i < ids.length; i++) {
				entityItemMapper.deleteEntityItem(ids[i]);
			}
	}

	@Override
	public List<EntityItem> selectByPage(String field, String entityId,int pageIndex,
			int pageSize) {
		int start =(pageIndex-1)*pageSize;
		return entityItemMapper.selectByPage(field, entityId,start, pageSize);
	}

}
