package com.zhuo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zhuo.entity.Car;


@Mapper
public interface CarMapper {

	List<Car> getList();
	
	void insertCar(Car car);
	 
    void delCar( Car car);
}
