package com.yjkj.framework.rbac.outcome.service.inte;


import java.util.List;

import javax.servlet.http.HttpSession;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.outcome.model.Outcome;

public interface OutcomeService {

	public Pager informationLoad(Pager pager,Outcome Outcome,HttpSession session) throws Exception;
	
	public List<Outcome> informationLoadAll(Outcome Outcome) throws Exception;
	
	public Integer count(Outcome Outcome) throws Exception;
	
	public Outcome informationLoadOne(Outcome Outcome) throws Exception;
	
	public void informationDelete(Outcome Outcome) throws Exception;
	
	public void informationAdd(Outcome Outcome) throws Exception;
	
	public void informationUpade(Outcome Outcome) throws Exception;
	
}
