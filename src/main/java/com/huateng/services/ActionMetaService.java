package com.huateng.services;

import com.huateng.model.ActionMeta;

/**
 * 规则动作的Service接口
 * @author zhuenran
 *
 */
public interface ActionMetaService {

	/**
	 * 保存规则动作
	 * @param actionMeta
	 * @param variables
	 */
	public void saveActionMeta(ActionMeta actionMeta,String variables);
}
