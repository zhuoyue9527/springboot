package com.zhuo.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@PostMapping("/login")
	public String login(@RequestParam(value="username")String username,@RequestParam(value="password")String password) {
		if(username.equals(password)) {
			return "ok";
		}
		return "fail";
	}

}
