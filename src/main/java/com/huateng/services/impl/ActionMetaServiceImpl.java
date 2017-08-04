package com.huateng.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.huateng.dao.mapper.ActionMetaMapper;
import com.huateng.dao.mapper.ActionMetaVariableMapper;
import com.huateng.enums.DelFlag;
import com.huateng.model.ActionMeta;
import com.huateng.services.ActionMetaService;

/**
 * 规则动作的Service层实现类
 * @author zhuenran
 *
 */
@Service
public class ActionMetaServiceImpl implements ActionMetaService{

	@Autowired
	private ActionMetaMapper actionMetaMapper;
	
	@Autowired
	private ActionMetaVariableMapper actionMetaVariableMapper;
	@Override
	@Transactional(readOnly=false,isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void saveActionMeta(ActionMeta actionMeta, String variables) {
		actionMeta.setDateCreated(new Date());
		actionMeta.setDateUpdated(new Date());
		actionMeta.setDelFlag(DelFlag.UNDel.getFlag());
		actionMetaMapper.insertSelective(actionMeta);
		
		
	}

}
