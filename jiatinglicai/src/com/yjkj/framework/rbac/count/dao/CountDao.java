package com.yjkj.framework.rbac.count.dao;

import java.util.List;
import java.util.Map;

import com.yjkj.framework.rbac.count.model.Count;

public interface CountDao {

	public List<Count> countIncome(Map<String,Object> map) throws Exception;
	
	public List<Count> countOutcome(Map<String,Object> map) throws Exception;
	
	public Integer numIncome(Count count) throws Exception;
	
	public Integer numOutcome(Count count) throws Exception;
	
	
}
