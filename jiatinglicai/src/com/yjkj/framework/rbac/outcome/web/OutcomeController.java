package com.yjkj.framework.rbac.outcome.web;




import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.family.model.Family;
import com.yjkj.framework.rbac.family.service.impl.FamilyServiceImpl;
import com.yjkj.framework.rbac.family.service.inte.FamilyService;
import com.yjkj.framework.rbac.outcome.model.Outcome;
import com.yjkj.framework.rbac.outcome.service.impl.OutcomeServiceImpl;
import com.yjkj.framework.rbac.outcome.service.inte.OutcomeService;
import com.yjkj.framework.rbac.typee.model.Typee;
import com.yjkj.framework.rbac.typee.service.impl.TypeeServiceImpl;
import com.yjkj.framework.rbac.typee.service.inte.TypeeService;
import com.yjkj.framework.rbac.userInfo.model.UserInfo;

@Controller
@RequestMapping("/outcome")
public class OutcomeController {
	
	@Autowired
	private OutcomeService outcomeService = new OutcomeServiceImpl();
	
	@Autowired
	private TypeeService typeeService = new TypeeServiceImpl();
	
	@Autowired
	private FamilyService familyService = new FamilyServiceImpl();

	@RequestMapping("/informationLoad")
	public String informationLoad(Pager pager,Model model,Outcome Outcome,HttpSession session) {
		try {
			UserInfo userInfo = (UserInfo) session.getAttribute("User");
			Outcome.setUser_id(userInfo.getId());
		pager = this.outcomeService.informationLoad(pager,Outcome,session);
		model.addAttribute("outcomeList", pager);
		model.addAttribute("outcome", Outcome);
		return "jsp/OutcomeTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadOne")
	public String informationLoadOne(Outcome Outcome,Model model,HttpSession session) {
		
		try {
			Typee typee = new Typee();
			UserInfo userInfo = (UserInfo) session.getAttribute("User");
			typee.setUser_id(userInfo.getId());
			typee.setType("2");
			Family family = new Family();
			family.setUser_id(userInfo.getId());
			model.addAttribute("typeeList", this.typeeService.informationLoadAll(typee));
			model.addAttribute("familyList", this.familyService.informationLoadAll(family));
			Outcome = this.outcomeService.informationLoadOne(Outcome);
			model.addAttribute("outcome", Outcome);
			return "jsp/Outcome";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationAdd")
	public String informationAdd(Outcome Outcome,Model model) {
		
		try {
			
			this.outcomeService.informationAdd(Outcome);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationDelete")
	public String informationDelete(Outcome Outcome,Model model) {
		
		try {
			this.outcomeService.informationDelete(Outcome);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationUpdate")
	public String informationUpdate(Outcome Outcome,Model model) {
		
		try {
			this.outcomeService.informationUpade(Outcome);
			return "jsp/Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
}
