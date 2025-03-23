package com.yjkj.framework.rbac.family.service.inte;


import java.util.List;

import javax.servlet.http.HttpSession;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.family.model.Family;

public interface FamilyService {

	public Pager informationLoad(Pager pager,Family Family,HttpSession session) throws Exception;
	
	public List<Family> informationLoadAll(Family Family) throws Exception;
	
	public Integer count(Family Family) throws Exception;
	
	public Family informationLoadOne(Family Family) throws Exception;
	
	public void informationDelete(Family Family) throws Exception;
	
	public void informationAdd(Family Family) throws Exception;
	
	public void informationUpade(Family Family) throws Exception;
	
}
