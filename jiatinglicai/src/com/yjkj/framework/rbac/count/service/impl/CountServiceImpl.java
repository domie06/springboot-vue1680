package com.yjkj.framework.rbac.count.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.yjkj.framework.base.basemodel.BaseService;
import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.count.model.Count;
import com.yjkj.framework.rbac.count.service.inte.CountService;
@Service
public class CountServiceImpl extends BaseService implements CountService {

	
	@Override
	public Pager countIncome(Pager pager,Count Count,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("count", Count);
		List<Count> list = this.countDao.countIncome(map);
		pager.setDatas(list);
		pager.setTotalCount(this.numIncome(Count));
		return pager;
	}
	
	@Override
	public Pager countOutcome(Pager pager,Count Count,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("count", Count);
		List<Count> list = this.countDao.countOutcome(map);
		pager.setDatas(list);
		pager.setTotalCount(this.numOutcome(Count));
		return pager;
	}

	@Override
	public Integer numIncome(Count Count) throws Exception {
		Integer count = this.countDao.numIncome(Count);
		return count;
	}
	
	@Override
	public Integer numOutcome(Count Count) throws Exception {
		Integer count = this.countDao.numOutcome(Count);
		return count;
	}

}
