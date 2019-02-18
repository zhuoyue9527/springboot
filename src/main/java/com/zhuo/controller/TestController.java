package com.zhuo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@GetMapping("/test")
	@ResponseBody
	public String fun() {
		return "test";
	}
}
