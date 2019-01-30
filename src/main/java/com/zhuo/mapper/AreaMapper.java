package com.zhuo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zhuo.entity.Area;


@Mapper
public interface AreaMapper {

	List<Area> findAreaAll();
	
	List<Area> queryArea();
	
	Area getAreaById(int areaId);
	
	int insertArea(Area area);
	
	int updateArea(Area area);
	
	int deleteArea(int areaId);
	
	
	
	
	
	
	
	
	
	
	
}
