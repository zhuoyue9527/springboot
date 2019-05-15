package com.zhuo.utils;

import com.zhuo.response.ResultMsg;

public class ResultUtil {

	public static ResultMsg success(Object object) {
		ResultMsg msg = new ResultMsg();
		msg.setCode(0);
		msg.setMsg("成功");
		msg.setData(object);
		return msg ;
	}
	
	public static ResultMsg success() {
		return success(null);
	}
	
	public static ResultMsg error(Integer code ,String msg) {
		ResultMsg result = new ResultMsg();
		result.setCode(code);
		result.setMsg(msg);
		return result ;
	}
}
