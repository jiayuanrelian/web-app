package com.huateng.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.support.json.JSONUtils;
import com.huateng.enums.DelFlag;
import com.huateng.exception.BusinessException;
import com.huateng.exception.errorcode.LuoErrorCode;
import com.huateng.model.EntityItem;
import com.huateng.services.IEntityItemService;

/**
 * 规则实体属性
 * @author zhuenran
 *
 */
@Controller
@RequestMapping(value="gzEntityItemController")
public class GzEntityItemController {

	@Autowired
	private IEntityItemService entityItemService;
	/**
	 * 跳转到实体属性页面
	 * @return
	 */
	@RequestMapping(value="goGzEnityItem.do",method=RequestMethod.GET)
	public ModelAndView goGzEnityItem(@RequestParam(value="id")String id){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("id", id);
		modelAndView.setViewName("enitiy/enitiy_item");
		return modelAndView;
	}
	
	/**
	 * 保存规则实体属性
	 * @param entity
	 * @param response
	 * @throws BusinessException
	 */
	@RequestMapping(value="saveEntityItem.do",method=RequestMethod.POST)
	private void saveEntityItem(EntityItem entityItem,HttpServletResponse response) throws BusinessException{
		entityItem.setDateCreated(new Date());
		entityItem.setDateUpdated(new Date());
		entityItem.setDelFlag(DelFlag.UNDel.getFlag());
		entityItemService.saveEntityItem(entityItem);
		DoneWell(response,LuoErrorCode.SUCCESS_ADD_ENTITYITEM.getDesc());
	}
	
	/**
	 * 批量删除实体属性
	 * @param ids
	 * @param response
	 */
	@RequestMapping(value="deleteEntityItem.do",method=RequestMethod.POST)
	private void deleteEntityItem(String[] ids,HttpServletResponse response){
		entityItemService.deleteEntityItem(ids);
		DoneWell(response, LuoErrorCode.SUCCESS_DEL_ENTITYITEM.getDesc());
	};
	
	/**
	 * 分页查询
	 * @param entityId
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@RequestMapping(value="selectByPage.do",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	private List<EntityItem> selectByPage(@RequestParam(value="entityId")String entityId,@RequestParam(value="page",defaultValue="1")int pageIndex,
			@RequestParam(value="rows",defaultValue="10")int pageSize){
		String field=null;
		List<EntityItem> entities = entityItemService.selectByPage(field, entityId,pageIndex, pageSize);
		return entities;
	}
	
	/**
	 * 处理成功
	 * @param response
	 */
	private void DoneWell(HttpServletResponse response,String message) {
		Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", true);
        map.put("message", message);
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.write(JSONUtils.toJSONString(map));
	        writer.flush();
	        writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
