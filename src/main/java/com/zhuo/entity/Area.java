package com.zhuo.entity;

import java.io.Serializable;
import java.util.Date;

public class Area implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int areaId ;
	
	private String areaName;
	
	private int priority ;
	
	private Date createTime ;
	
	private Date lastEditTime ;

	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastEditTime() {
		return lastEditTime;
	}

	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}
	
	
}
