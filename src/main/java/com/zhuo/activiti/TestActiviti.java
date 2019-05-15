package com.zhuo.activiti;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class TestActiviti {

	@Resource(name = "activityService")
	private ActivityService activityService;

//	@PostMapping("testActiviti")
//	public void leaveProcess() {
//		activityService.startActivity();
//	}
}
