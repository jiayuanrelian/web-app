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
import com.huateng.model.Entity;
import com.huateng.services.IEntityService;


@Controller
@RequestMapping(value="gzEnityController")
public class GzEntityController {
	
	@Autowired
	private IEntityService entityService;
	
	@RequestMapping(value="goGzEnity.do",method=RequestMethod.GET)
	public ModelAndView goGzEnity(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("enitiy/enitiy");
		return modelAndView;
	}
	@RequestMapping(value="selectByPage.do",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	private Map<String,Object> selectByPage(String name,@RequestParam(value="page",defaultValue="1")int pageIndex,
			@RequestParam(value="rows",defaultValue="10")int pageSize){
		Map<String,Object> map = new HashMap<String, Object>();
		List<Entity> entities = entityService.selectByPage(name, pageIndex, pageSize);
		int totalCount = entityService.selectByPageCount(name);
		map.put("total", totalCount);
		map.put("rows", entities);
		return map;
	}
	
	@RequestMapping(value="saveEntity.do",method=RequestMethod.POST)
	private void saveEntity(Entity entity,HttpServletResponse response) throws BusinessException{
		entity.setDateCreated(new Date());
		entity.setDateUpdated(new Date());
		entity.setDelFlag(DelFlag.UNDel.getFlag());
		entityService.saveEntity(entity);
		DoneWell(response);
	}
	/**
	 * 批量删除数据
	 * @param ids
	 * @param response
	 * @throws BusinessException
	 */
	@RequestMapping(value="deleteByBath.do",method=RequestMethod.POST)
	private void deleteByBath(String[] ids,HttpServletResponse response) throws BusinessException{
		if (ids.length == 0) {
			throw new BusinessException("至少选择一条数据");
		}
		entityService.deleteByBath(ids);
		DoneWell(response);
	}
	/**
	 * 处理成功
	 * @param response
	 */
	private void DoneWell(HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", true);
        map.put("message", "操作成功");
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
