package com.zhuo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhuo.entity.Area;
import com.zhuo.mapper.AreaMapper;

@RestController
public class AreaController {

	@Autowired
	private AreaMapper mapper ;
	
	@GetMapping("/area")
	public Area fun() {
		Area area = mapper.findAreaAll();
		return area ;
	}
}
