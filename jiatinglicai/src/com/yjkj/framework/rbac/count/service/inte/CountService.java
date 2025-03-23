package com.yjkj.framework.rbac.count.service.inte;



import javax.servlet.http.HttpSession;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.count.model.Count;

public interface CountService {

	public Pager countIncome(Pager pager,Count count,HttpSession session) throws Exception;

	public Pager countOutcome(Pager pager,Count count,HttpSession session) throws Exception;
	
	public Integer numIncome(Count Count) throws Exception;
	
	public Integer numOutcome(Count Count) throws Exception;
	
	
}
