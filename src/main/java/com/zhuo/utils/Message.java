package com.zhuo.utils;

import java.io.Serializable;

public class Message  implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String phones;

	private String content ;
	
	private String sign ;
	
	private String extend ;

	@Override
	public String toString() {
		return "Message [phones=" + phones + ", content=" + content + ", sign=" + sign + ", extend=" + extend + "]";
	}

	public String getPhones() {
		return phones;
	}

	public void setPhones(String phones) {
		this.phones = phones;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getExtend() {
		return extend;
	}

	public void setExtend(String extend) {
		this.extend = extend;
	}

	
}
