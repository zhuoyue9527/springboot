package com.zhuo.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

	@RequestMapping(value ="/user/home")
	@ResponseBody
	public String home() {
		System.out.println("/-/-----------------------");
		return "user home";
	}
}
