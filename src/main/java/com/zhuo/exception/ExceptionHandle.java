package com.zhuo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhuo.response.ResultMsg;
import com.zhuo.utils.ResultUtil;

@ControllerAdvice
public class ExceptionHandle {

	private Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
	
	
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ResultMsg handle(Exception e) {
		if(e instanceof AreaException) {
			AreaException area = (AreaException) e ;
			return ResultUtil.error(area.getCode(), area.getMessage());
		}
//		logger.error("[xitong yichang]{}",e);
		return ResultUtil.error(-1, e.getMessage());
	}
}
