package com.zhuo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		Area area = mapper.findAreaAll();
		return ResultUtil.success(area) ;
	}
	
	@GetMapping("/area/{id}")
	public void areaId(@PathVariable("id") Integer id) throws Exception {
		areaService.areaId(id);
	}
}
