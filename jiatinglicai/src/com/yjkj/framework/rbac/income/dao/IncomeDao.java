package com.yjkj.framework.rbac.income.dao;

import java.util.List;
import java.util.Map;

import com.yjkj.framework.rbac.income.model.Income;

public interface IncomeDao {

	public List<Income> informationLoad(Map<String,Object> map) throws Exception;
	
	public List<Income> informationLoadAll(Income Income) throws Exception;
	
	public Integer count(Income Income) throws Exception;
	
	public Income informationLoadOne(Income Income) throws Exception;
	
	public void informationDelete(Income Income) throws Exception;
	
	public void informationAdd(Income Income) throws Exception;
	
	public void informationUpdate(Income Income) throws Exception;
	
}
