package com.zhuo.exception;

public enum ExceptionEnums {

	UNKNOWN_ERROR(-1,"未知错误"),
	SUCCESS(0,"成功"),
	SERVICE_ERROR(100,"业务错误")
	;
	
	private Integer code;

	private String message ;

	private ExceptionEnums(Integer code, String message) {
		this.code = code;
		this.message = message;
	}


	public String getMessage() {
		return message;
	}


	public Integer getCode() {
		return code;
	}



	
	
	
}
