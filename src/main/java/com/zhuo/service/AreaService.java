package com.zhuo.service;

import org.springframework.stereotype.Service;

import com.zhuo.exception.AreaException;
import com.zhuo.exception.ExceptionEnums;

@Service
public class AreaService {
	
	public void areaId (Integer id) throws Exception {
		if(id.equals(2)) {
			throw new AreaException(ExceptionEnums.SERVICE_ERROR);
		}else {
			throw new AreaException(ExceptionEnums.UNKNOWN_ERROR);
		}
	}
}
