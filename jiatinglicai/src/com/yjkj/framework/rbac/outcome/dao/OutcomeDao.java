package com.yjkj.framework.rbac.outcome.dao;

import java.util.List;
import java.util.Map;

import com.yjkj.framework.rbac.outcome.model.Outcome;

public interface OutcomeDao {

	public List<Outcome> informationLoad(Map<String,Object> map) throws Exception;
	
	public List<Outcome> informationLoadAll(Outcome Outcome) throws Exception;
	
	public Integer count(Outcome Outcome) throws Exception;
	
	public Outcome informationLoadOne(Outcome Outcome) throws Exception;
	
	public void informationDelete(Outcome Outcome) throws Exception;
	
	public void informationAdd(Outcome Outcome) throws Exception;
	
	public void informationUpdate(Outcome Outcome) throws Exception;
	
}
