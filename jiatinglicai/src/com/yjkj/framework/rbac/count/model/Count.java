package com.yjkj.framework.rbac.count.model;

import java.math.BigDecimal;

import com.yjkj.framework.base.basemodel.BaseModel;


public class Count extends BaseModel{
	
	private BigDecimal priceSum;
	private String user_id;
	private String start_time;
	private String end_time;
	private String searchName;
	public BigDecimal getPriceSum() {
		return priceSum;
	}

	public void setPriceSum(BigDecimal priceSum) {
		this.priceSum = priceSum;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	
	
	
}
