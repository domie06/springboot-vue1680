package com.yjkj.framework.rbac.income.service.inte;


import java.util.List;

import javax.servlet.http.HttpSession;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.income.model.Income;

public interface IncomeService {

	public Pager informationLoad(Pager pager,Income Income,HttpSession session) throws Exception;
	
	public List<Income> informationLoadAll(Income Income) throws Exception;
	
	public Integer count(Income Income) throws Exception;
	
	public Income informationLoadOne(Income Income) throws Exception;
	
	public void informationDelete(Income Income) throws Exception;
	
	public void informationAdd(Income Income) throws Exception;
	
	public void informationUpade(Income Income) throws Exception;
	
}
