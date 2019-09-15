package com.zhuo.utils;

import java.io.Serializable;
import java.util.List;

public class RequestMessage  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String account ;
	
	private String password;
	
	private String ukey;
	
	private Message data ;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUkey() {
		return ukey;
	}

	public void setUkey(String ukey) {
		this.ukey = ukey;
	}

	 

	public Message getData() {
		return data;
	}

	public void setData(Message data) {
		this.data = data;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "RequestMessage [account=" + account + ", password=" + password + ", ukey=" + ukey + ", data=" + data
				+ "]";
	}

	
	
	
}
