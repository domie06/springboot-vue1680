package com.yjkj.framework.rbac.typee.service.inte;


import java.util.List;

import javax.servlet.http.HttpSession;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.typee.model.Typee;

public interface TypeeService {

	public Pager informationLoad(Pager pager,Typee Typee,HttpSession session) throws Exception;
	
	public List<Typee> informationLoadAll(Typee Typee) throws Exception;
	
	public Integer count(Typee Typee) throws Exception;
	
	public Typee informationLoadOne(Typee Typee) throws Exception;
	
	public void informationDelete(Typee Typee) throws Exception;
	
	public void informationAdd(Typee Typee) throws Exception;
	
	public void informationUpade(Typee Typee) throws Exception;
	
}
