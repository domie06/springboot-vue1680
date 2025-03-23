package com.yjkj.framework.rbac.family.model;

import com.yjkj.framework.base.basemodel.BaseModel;
import com.yjkj.framework.rbac.userInfo.model.UserInfo;


public class Family extends BaseModel{
	
	private String user_id;
	private UserInfo userInfo;
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
	
	
	
}
