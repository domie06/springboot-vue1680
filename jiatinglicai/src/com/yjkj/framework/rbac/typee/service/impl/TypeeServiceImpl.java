package com.yjkj.framework.rbac.typee.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.yjkj.framework.base.basemodel.BaseService;
import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.base.regular.Regular;
import com.yjkj.framework.base.regular.date.CreatDate;
import com.yjkj.framework.rbac.typee.model.Typee;
import com.yjkj.framework.rbac.typee.service.inte.TypeeService;
@Service
public class TypeeServiceImpl extends BaseService implements TypeeService {

	
	@Override
	public Pager informationLoad(Pager pager,Typee Typee,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("typee", Typee);
		List<Typee> list = this.typeeDao.informationLoad(map);
		pager.setDatas(list);
		pager.setTotalCount(this.count(Typee));
		return pager;
	}

	@Override
	public List<Typee> informationLoadAll(Typee Typee) throws Exception {
		List<Typee> list = this.typeeDao.informationLoadAll(Typee);
		return list;
	}
	

	@Override
	public Integer count(Typee Typee) throws Exception {
		Integer count = this.typeeDao.count(Typee);
		return count;
	}

	@Override
	public Typee informationLoadOne(Typee Typee) throws Exception {
			Typee = this.typeeDao.informationLoadOne(Typee);
		return Typee;
	}

	@Override
	public void informationDelete(Typee Typee) throws Exception {
			this.typeeDao.informationDelete(Typee);

	}

	@Override
	public void informationAdd(Typee Typee) throws Exception {
			Typee.setId(Regular.createId());
			Typee.setCreatetime(CreatDate.getDate());
			this.typeeDao.informationAdd(Typee);

	}

	@Override
	public void informationUpade(Typee Typee) throws Exception {
			this.typeeDao.informationUpdate(Typee);
	}

}
