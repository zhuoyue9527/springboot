package com.zhuo.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zhuo.entity.Area;
import com.zhuo.mapper.AreaMapper;
import com.zhuo.service.AreaService;
import com.zhuo.utils.ResultUtil;

@RestController
public class AreaController {

	private static final Logger logger = LoggerFactory.getLogger(AreaController.class);
	
	
	@Autowired
	private AreaMapper mapper ;
	
	@Autowired
	private AreaService areaService ;
	
	
	@GetMapping("/area")
	public Object fun() {
		logger.info("area------------------");
		List<Area> list = mapper.findAreaAll();
		return ResultUtil.success(list) ;
	}
	
	@GetMapping("areaId/{id}")
	public Object areaId(@PathVariable("id") Integer id) throws Exception {
		areaService.areaId(id);
		return "" ;
	}
	@GetMapping("/getAreaById")
	public Object getAreabyId(Integer areaId) throws Exception {
		Area area = mapper.getAreaById(areaId);
		logger.info("area {}",area);
		return ResultUtil.success(area);
	}
	
	@PostMapping("/modifyArea")
	public Object modifyArea(@RequestBody Area area) throws Exception {
		int result = mapper.updateArea(area);
		return ResultUtil.success(result);
	}
	
	@PostMapping("/addArea")
	public Object addArea(@RequestBody Area area) throws Exception {
		area.setCreateTime(new Date());
		int result = mapper.insertArea(area);
		return ResultUtil.success(result);
	}
	
	
	@GetMapping("/removeArea")
	public Object removeArea(Integer areaId) {
		Integer reuslt = mapper.deleteArea(areaId);
		if(1 == reuslt) {
			return ResultUtil.success();
		}else {
			return ResultUtil.error(100, "删除失败");
		}
	}
}
