package com.yjkj.framework.rbac.income.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.yjkj.framework.base.basemodel.BaseService;
import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.base.regular.Regular;
import com.yjkj.framework.base.regular.date.CreatDate;
import com.yjkj.framework.rbac.income.model.Income;
import com.yjkj.framework.rbac.income.service.inte.IncomeService;
@Service
public class IncomeServiceImpl extends BaseService implements IncomeService {

	
	@Override
	public Pager informationLoad(Pager pager,Income Income,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("income", Income);
		List<Income> list = this.incomeDao.informationLoad(map);
		pager.setDatas(list);
		pager.setTotalCount(this.count(Income));
		return pager;
	}

	@Override
	public List<Income> informationLoadAll(Income Income) throws Exception {
		List<Income> list = this.incomeDao.informationLoadAll(Income);
		return list;
	}
	

	@Override
	public Integer count(Income Income) throws Exception {
		Integer count = this.incomeDao.count(Income);
		return count;
	}

	@Override
	public Income informationLoadOne(Income Income) throws Exception {
		
			Income = this.incomeDao.informationLoadOne(Income);
		return Income;
	}

	@Override
	public void informationDelete(Income Income) throws Exception {
			this.incomeDao.informationDelete(Income);

	}

	@Override
	public void informationAdd(Income Income) throws Exception {
			Income.setId(Regular.createId());
			Income.setCreatetime(CreatDate.getDate());
			this.incomeDao.informationAdd(Income);

	}

	@Override
	public void informationUpade(Income Income) throws Exception {
			this.incomeDao.informationUpdate(Income);
	}

}
