package com.zhuo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zhuo.entity.Car;
import com.zhuo.entity.User;
import com.zhuo.mapper.CarMapper;

@RestController
public class TestController {

	@Autowired
	private CarMapper mapper ;
	
	@GetMapping("/user")
    public User get() {
		return new User("1", "socks", "123456", new Date(), "GMT");
		
	}
	
	@PostMapping("/postUer")
    public User post() {
		return new User("1", "socks", "123456", new Date(), "GMT");
	}
	
	@GetMapping("/getList")
	public List<Car> getList() {
		List<Car> list = mapper.getList();
		return list ;
	}
	
	@PostMapping("/addCar")
	public void addCar(@RequestBody Car car) {
		System.out.println(car.toString());
		car.setCtime(new Date());
		mapper.insertCar(car);
		 
	}
	
	@PostMapping("/delCar")
	public void delCar(@RequestBody Car car) {
		mapper.delCar(car);
		 
	}
	
	
}
