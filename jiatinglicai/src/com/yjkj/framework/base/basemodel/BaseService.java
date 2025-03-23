package com.yjkj.framework.base.basemodel;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yjkj.framework.rbac.count.dao.CountDao;
import com.yjkj.framework.rbac.family.dao.FamilyDao;
import com.yjkj.framework.rbac.income.dao.IncomeDao;
import com.yjkj.framework.rbac.notice.dao.NoticeDao;
import com.yjkj.framework.rbac.outcome.dao.OutcomeDao;
import com.yjkj.framework.rbac.typee.dao.TypeeDao;
@Service
public class BaseService {
	
	
	
	
	
	
	@Autowired
	public TypeeDao typeeDao;
	
	
	@Autowired
	public NoticeDao noticeDao;
	
	@Autowired
	public FamilyDao familyDao;
	
	@Autowired
	public IncomeDao incomeDao;
	
	@Autowired
	public OutcomeDao outcomeDao;
	
	@Autowired
	public CountDao countDao;
	

}
