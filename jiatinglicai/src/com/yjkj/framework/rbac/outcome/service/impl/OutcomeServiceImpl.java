package com.yjkj.framework.rbac.outcome.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.yjkj.framework.base.basemodel.BaseService;
import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.base.regular.Regular;
import com.yjkj.framework.base.regular.date.CreatDate;
import com.yjkj.framework.rbac.outcome.model.Outcome;
import com.yjkj.framework.rbac.outcome.service.inte.OutcomeService;
@Service
public class OutcomeServiceImpl extends BaseService implements OutcomeService {

	
	@Override
	public Pager informationLoad(Pager pager,Outcome Outcome,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("outcome", Outcome);
		List<Outcome> list = this.outcomeDao.informationLoad(map);
		pager.setDatas(list);
		pager.setTotalCount(this.count(Outcome));
		return pager;
	}

	@Override
	public List<Outcome> informationLoadAll(Outcome Outcome) throws Exception {
		List<Outcome> list = this.outcomeDao.informationLoadAll(Outcome);
		return list;
	}
	

	@Override
	public Integer count(Outcome Outcome) throws Exception {
		Integer count = this.outcomeDao.count(Outcome);
		return count;
	}

	@Override
	public Outcome informationLoadOne(Outcome Outcome) throws Exception {
			Outcome = this.outcomeDao.informationLoadOne(Outcome);
		return Outcome;
	}

	@Override
	public void informationDelete(Outcome Outcome) throws Exception {
			this.outcomeDao.informationDelete(Outcome);

	}

	@Override
	public void informationAdd(Outcome Outcome) throws Exception {
			Outcome.setId(Regular.createId());
			Outcome.setCreatetime(CreatDate.getDate());
			this.outcomeDao.informationAdd(Outcome);

	}

	@Override
	public void informationUpade(Outcome Outcome) throws Exception {
			this.outcomeDao.informationUpdate(Outcome);
	}

}
