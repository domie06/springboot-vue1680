package com.yjkj.framework.rbac.typee.web;




import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.typee.model.Typee;
import com.yjkj.framework.rbac.typee.service.impl.TypeeServiceImpl;
import com.yjkj.framework.rbac.typee.service.inte.TypeeService;
import com.yjkj.framework.rbac.userInfo.model.UserInfo;

@Controller
@RequestMapping("/typee")
public class TypeeController {
	
	@Autowired
	private TypeeService typeeService = new TypeeServiceImpl();
	

	@RequestMapping("/informationLoad")
	public String informationLoad(Pager pager,Model model,Typee Typee,HttpSession session) {
		try {
			UserInfo userInfo = (UserInfo) session.getAttribute("User");
			Typee.setUser_id(userInfo.getId());
		pager = this.typeeService.informationLoad(pager,Typee,session);
		model.addAttribute("typeeList", pager);
		model.addAttribute("typee", Typee);
		return "jsp/TypeeTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/informationLoadOne")
	public String informationLoadOne(Typee Typee,Model model) {
		
		try {
			Typee = this.typeeService.informationLoadOne(Typee);
			model.addAttribute("typee", Typee);
			return "jsp/Typee";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationAdd")
	public String informationAdd(Typee Typee,Model model) {
		
		try {
			
			this.typeeService.informationAdd(Typee);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationDelete")
	public String informationDelete(Typee Typee,Model model) {
		
		try {
			this.typeeService.informationDelete(Typee);
			return "jsp/Success";
		}catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
	@RequestMapping("/informationUpdate")
	public String informationUpdate(Typee Typee,Model model) {
		
		try {
			this.typeeService.informationUpade(Typee);
			return "jsp/Success";
		} catch (Exception e) {
			e.printStackTrace();
			return "jsp/Failed";
		}
		
	}
	
}
