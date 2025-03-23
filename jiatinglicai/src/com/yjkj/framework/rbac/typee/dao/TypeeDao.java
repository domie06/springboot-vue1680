package com.yjkj.framework.rbac.typee.dao;

import java.util.List;
import java.util.Map;

import com.yjkj.framework.rbac.typee.model.Typee;

public interface TypeeDao {

	public List<Typee> informationLoad(Map<String,Object> map) throws Exception;
	
	public List<Typee> informationLoadAll(Typee Typee) throws Exception;
	
	public Integer count(Typee Typee) throws Exception;
	
	public Typee informationLoadOne(Typee Typee) throws Exception;
	
	public void informationDelete(Typee Typee) throws Exception;
	
	public void informationAdd(Typee Typee) throws Exception;
	
	public void informationUpdate(Typee Typee) throws Exception;
	
}
