package com.yjkj.framework.rbac.outcome.model;

import java.math.BigDecimal;

import com.yjkj.framework.base.basemodel.BaseModel;
import com.yjkj.framework.rbac.family.model.Family;
import com.yjkj.framework.rbac.typee.model.Typee;
import com.yjkj.framework.rbac.userInfo.model.UserInfo;


public class Outcome extends BaseModel{
	
	private String type_id;
	private String user_id;
	private String family_id;
	private BigDecimal price;
	private String come_date;
	private UserInfo userInfo;
	private Typee typee;
	private Family family;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public String getType_id() {
		return type_id;
	}
	public void setType_id(String type_id) {
		this.type_id = type_id;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getCome_date() {
		return come_date;
	}
	public void setCome_date(String come_date) {
		this.come_date = come_date;
	}
	public Typee getTypee() {
		return typee;
	}
	public void setTypee(Typee typee) {
		this.typee = typee;
	}
	public String getFamily_id() {
		return family_id;
	}
	public void setFamily_id(String family_id) {
		this.family_id = family_id;
	}
	public Family getFamily() {
		return family;
	}
	public void setFamily(Family family) {
		this.family = family;
	}
	
	
	
}
