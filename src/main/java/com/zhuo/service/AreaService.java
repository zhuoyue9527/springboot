package com.zhuo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhuo.exception.AreaException;
import com.zhuo.exception.ExceptionEnums;
import com.zhuo.mapper.AreaMapper;

@Service
public class AreaService {

	@Autowired
	private AreaMapper mapper ;
	
	public void areaId (Integer id) throws Exception {
		if(id.equals(2)) {
			throw new AreaException(ExceptionEnums.SERVICE_ERROR);
		}else {
			throw new Exception(ExceptionEnums.UNKNOWN_ERROR.getMessage());
		}
	}
}
