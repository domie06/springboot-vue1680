package com.yjkj.framework.rbac.count.web;




import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjkj.framework.base.pager.Pager;
import com.yjkj.framework.rbac.count.model.Count;
import com.yjkj.framework.rbac.count.service.impl.CountServiceImpl;
import com.yjkj.framework.rbac.count.service.inte.CountService;
import com.yjkj.framework.rbac.userInfo.model.UserInfo;

@Controller
@RequestMapping("/count")
public class CountController {
	
	@Autowired
	private CountService countService = new CountServiceImpl();
	

	@RequestMapping("/countIncome")
	public String informationLoad(Pager pager,Model model,Count Count,HttpSession session) {
		try {
			UserInfo userInfo = (UserInfo) session.getAttribute("User");
			Count.setUser_id(userInfo.getId());
		pager = this.countService.countIncome(pager,Count,session);
		model.addAttribute("countList", pager);
		model.addAttribute("countt", Count);
		return "jsp/CountIncomeTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	@RequestMapping("/countOutcome")
	public String countOutcome(Pager pager,Model model,Count Count,HttpSession session) {
		try {
			UserInfo userInfo = (UserInfo) session.getAttribute("User");
			Count.setUser_id(userInfo.getId());
		pager = this.countService.countOutcome(pager,Count,session);
		model.addAttribute("countList", pager);
		model.addAttribute("countt", Count);
		return "jsp/CountOutcomeTable";
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
			return "jsp/Failed";
		}
	}
	
	
}
