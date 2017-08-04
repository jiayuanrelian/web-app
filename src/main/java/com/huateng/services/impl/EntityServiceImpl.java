package com.huateng.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.dao.mapper.EntityMapper;
import com.huateng.exception.BusinessException;
import com.huateng.exception.errorcode.LuoErrorCode;
import com.huateng.model.Entity;
import com.huateng.services.IEntityService;
@Service
public class EntityServiceImpl implements IEntityService{

	@Autowired
	private EntityMapper entityMapper;
	@Override
	@Transactional(readOnly=true)
	public List<Entity> selectByPage(String name, int pageIndex, int pageSize) {
		int start =(pageIndex-1)*pageSize;
		return entityMapper.selectByPage(name, start, pageSize);
	}
	
	@Override
	@Transactional(readOnly=false,isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public int saveEntity(Entity entity) throws BusinessException {
		int count = entityMapper.selectByIdentify(entity.getIdentify());
		if (count >0) {
			throw new BusinessException(LuoErrorCode.NOT_REPEAT.getDesc());
		}
		int num = entityMapper.insertSelective(entity);
		return num;
	}

	@Override
	@Transactional(readOnly=true)
	public int selectByPageCount(String name) {
		return entityMapper.selectByPageCount(name);
	}

	@Override
	@Transactional(readOnly=false,isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void deleteByBath(String[] ids) {
		for (int i = 0; i < ids.length; i++) {
			entityMapper.deleteByBath(ids[i]);
		}
	}

}
