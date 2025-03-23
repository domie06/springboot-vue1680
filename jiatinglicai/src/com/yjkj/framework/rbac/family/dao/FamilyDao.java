package com.yjkj.framework.rbac.family.dao;

import java.util.List;
import java.util.Map;

import com.yjkj.framework.rbac.family.model.Family;

public interface FamilyDao {

	public List<Family> informationLoad(Map<String,Object> map) throws Exception;
	
	public List<Family> informationLoadAll(Family Family) throws Exception;
	
	public Integer count(Family Family) throws Exception;
	
	public Family informationLoadOne(Family Family) throws Exception;
	
	public void informationDelete(Family Family) throws Exception;
	
	public void informationAdd(Family Family) throws Exception;
	
	public void informationUpdate(Family Family) throws Exception;
	
}
