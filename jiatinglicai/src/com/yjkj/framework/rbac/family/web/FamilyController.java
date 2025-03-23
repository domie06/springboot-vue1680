package com.yjkj.framework.rbac.family.web;




import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.family.model.Family;
import com.yjkj.framework.rbac.family.service.impl.FamilyServiceImpl;
import com.yjkj.framework.rbac.family.service.inte.FamilyService;
import com.yjkj.framework.rbac.userInfo.model.UserInfo;

@Controller
@RequestMapping("/family")
public class FamilyController {
	
	@Autowired
	private FamilyService familyService = new FamilyServiceImpl();
	

	@RequestMapping("/informationLoad")
	public String informationLoad(Pager pager,Model model,Family Family,HttpSession session) {
		try {
			UserInfo userInfo = (UserInfo) session.getAttribute("User");
		Family.setUser_id(userInfo.getId());
		pager = this.familyService.informationLoad(pager,Family,session);
		model.addAttribute("familyList", pager);
		model.addAttribute("family", Family);
		return "jsp/FamilyTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadOne")
	public String informationLoadOne(Family Family,Model model) {
		
		try {
			Family = this.familyService.informationLoadOne(Family);
			model.addAttribute("family", Family);
			return "jsp/Family";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationAdd")
	public String informationAdd(Family Family,Model model) {
		
		try {
			
			this.familyService.informationAdd(Family);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationDelete")
	public String informationDelete(Family Family,Model model) {
		
		try {
			this.familyService.informationDelete(Family);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationUpdate")
	public String informationUpdate(Family Family,Model model) {
		
		try {
			this.familyService.informationUpade(Family);
			return "jsp/Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
}
