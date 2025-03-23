package com.yjkj.framework.rbac.income.web;




import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.family.model.Family;
import com.yjkj.framework.rbac.family.service.impl.FamilyServiceImpl;
import com.yjkj.framework.rbac.family.service.inte.FamilyService;
import com.yjkj.framework.rbac.income.model.Income;
import com.yjkj.framework.rbac.income.service.impl.IncomeServiceImpl;
import com.yjkj.framework.rbac.income.service.inte.IncomeService;
import com.yjkj.framework.rbac.typee.model.Typee;
import com.yjkj.framework.rbac.typee.service.impl.TypeeServiceImpl;
import com.yjkj.framework.rbac.typee.service.inte.TypeeService;
import com.yjkj.framework.rbac.userInfo.model.UserInfo;

@Controller
@RequestMapping("/income")
public class IncomeController {
	
	@Autowired
	private IncomeService incomeService = new IncomeServiceImpl();
	
	@Autowired
	private TypeeService typeeService = new TypeeServiceImpl();
	
	@Autowired
	private FamilyService familyService = new FamilyServiceImpl();

	@RequestMapping("/informationLoad")
	public String informationLoad(Pager pager,Model model,Income Income,HttpSession session) {
		try {
			UserInfo userInfo = (UserInfo) session.getAttribute("User");
			Income.setUser_id(userInfo.getId());
		pager = this.incomeService.informationLoad(pager,Income,session);
		model.addAttribute("incomeList", pager);
		model.addAttribute("income", Income);
		return "jsp/IncomeTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadOne")
	public String informationLoadOne(Income Income,Model model,HttpSession session) {
		
		try {
			Typee typee = new Typee();
			UserInfo userInfo = (UserInfo) session.getAttribute("User");
			typee.setUser_id(userInfo.getId());
			typee.setType("1");
			Family family = new Family();
			family.setUser_id(userInfo.getId());
			model.addAttribute("typeeList", this.typeeService.informationLoadAll(typee));
			model.addAttribute("familyList", this.familyService.informationLoadAll(family));
			Income = this.incomeService.informationLoadOne(Income);
			model.addAttribute("income", Income);
			return "jsp/Income";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationAdd")
	public String informationAdd(Income Income,Model model) {
		
		try {
			
			this.incomeService.informationAdd(Income);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationDelete")
	public String informationDelete(Income Income,Model model) {
		
		try {
			this.incomeService.informationDelete(Income);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationUpdate")
	public String informationUpdate(Income Income,Model model) {
		
		try {
			this.incomeService.informationUpade(Income);
			return "jsp/Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
}
