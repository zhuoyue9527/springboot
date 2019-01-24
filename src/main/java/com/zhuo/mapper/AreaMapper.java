package com.zhuo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.zhuo.entity.Area;


@Mapper
public interface AreaMapper {

	Area findAreaAll();
}
