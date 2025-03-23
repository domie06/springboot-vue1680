package com.yjkj.framework.rbac.family.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.yjkj.framework.base.basemodel.BaseService;
import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.base.regular.Regular;
import com.yjkj.framework.base.regular.date.CreatDate;
import com.yjkj.framework.rbac.family.model.Family;
import com.yjkj.framework.rbac.family.service.inte.FamilyService;
@Service
public class FamilyServiceImpl extends BaseService implements FamilyService {

	
	@Override
	public Pager informationLoad(Pager pager,Family Family,HttpSession session) throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("pager", pager);
		map.put("family", Family);
		List<Family> list = this.familyDao.informationLoad(map);
		pager.setDatas(list);
		pager.setTotalCount(this.count(Family));
		return pager;
	}

	@Override
	public List<Family> informationLoadAll(Family Family) throws Exception {
		List<Family> list = this.familyDao.informationLoadAll(Family);
		return list;
	}
	

	@Override
	public Integer count(Family Family) throws Exception {
		Integer count = this.familyDao.count(Family);
		return count;
	}

	@Override
	public Family informationLoadOne(Family Family) throws Exception {
			Family = this.familyDao.informationLoadOne(Family);
		return Family;
	}

	@Override
	public void informationDelete(Family Family) throws Exception {
			this.familyDao.informationDelete(Family);

	}

	@Override
	public void informationAdd(Family Family) throws Exception {
			Family.setId(Regular.createId());
			Family.setCreatetime(CreatDate.getDate());
			this.familyDao.informationAdd(Family);

	}

	@Override
	public void informationUpade(Family Family) throws Exception {
			this.familyDao.informationUpdate(Family);
	}

}
