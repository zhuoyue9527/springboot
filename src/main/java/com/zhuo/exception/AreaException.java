package com.zhuo.exception;

public class AreaException extends RuntimeException{

	private Integer code ;

	public AreaException(ExceptionEnums exceptionEnums) {
		super(exceptionEnums.getMessage());
		this.code = exceptionEnums.getCode();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
	
	
}
