package com.zhuo.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class People {

	@PostMapping("/people")
	public void login(@RequestParam(value="username")String username,@RequestParam(value="password")String password) {
		System.out.println("hello");
	}

}
