package com.zhuo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhuo.activiti.ActivityService;

@Controller
public class TestController {

	@GetMapping("/test")
	@ResponseBody
	public String fun() {
		return "test";
	}
	
	@Autowired
	private ActivityService activityService;

	@PostMapping("testActiviti")
	public void leaveProcess() {
		activityService.startActivity();
	}
}
