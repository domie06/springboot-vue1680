package com.yjkj.framework.rbac.web;



import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yjkj.framework.rbac.family.model.Family;
import com.yjkj.framework.rbac.family.service.impl.FamilyServiceImpl;
import com.yjkj.framework.rbac.family.service.inte.FamilyService;
import com.yjkj.framework.rbac.functionInfo.service.impl.FunctionServiceImpl;
import com.yjkj.framework.rbac.functionInfo.service.inte.FunctionService;
import com.yjkj.framework.rbac.notice.model.Notice;
import com.yjkj.framework.rbac.notice.service.impl.NoticeServiceImpl;
import com.yjkj.framework.rbac.notice.service.inte.NoticeService;
import com.yjkj.framework.rbac.roleInfo.model.RoleInfo;
import com.yjkj.framework.rbac.roleInfo.service.impl.RoleInfoServiceImpl;
import com.yjkj.framework.rbac.roleInfo.service.inte.RoleInfoService;
import com.yjkj.framework.rbac.typee.model.Typee;
import com.yjkj.framework.rbac.typee.service.impl.TypeeServiceImpl;
import com.yjkj.framework.rbac.typee.service.inte.TypeeService;
import com.yjkj.framework.rbac.userInfo.model.UserInfo;



@Controller
@RequestMapping("/request")
public class RequestController {
	
	@Autowired
	private RoleInfoService ris = new RoleInfoServiceImpl();

	@Autowired
	private FunctionService fs = new FunctionServiceImpl();
	
	@Autowired
	private TypeeService typeeService = new TypeeServiceImpl();
	
	@Autowired
	private NoticeService noticeService = new NoticeServiceImpl();
	
	@Autowired
	private FamilyService familyService = new FamilyServiceImpl();
	
	
	
	
	
	

	
	@RequestMapping("/login")
	public String login() throws IOException {
		return "jsp/Login";
		
	}
	@RequestMapping("/index")
	public String main(Model model) {
		return "jsp/iframemain";
	}
	
	@RequestMapping("/passUpdate")
	public String passUpdate(String id,Model model) {
		model.addAttribute("id", id);
		return "jsp/PassUpdate";
	}
	@RequestMapping("/right")
	public String index(Model model) {
		try {
			Notice notice = new Notice();
			notice.setId("1");
				model.addAttribute("notice", this.noticeService.informationLoadOne(notice));
			} catch (Exception e) {
				e.printStackTrace();
			}
		return "jsp/index";
	}
	
	@RequestMapping("/top")
	public String top() {
		return "jsp/top";
	}
	
	@RequestMapping("/sign")
	public String sign() {
		return "jsp/Sign";
	}
	
	@RequestMapping("/userAdd")
	public String userAdd(Model model){
		try{
		List<RoleInfo> list = this.ris.query();
		model.addAttribute("role", list);
		}catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
		}
		return "jsp/UserAdd";
	}
	
	@RequestMapping("/functionAdd")
	public String functionAdd(){
		return "jsp/FunctionAdd";
	}
	@RequestMapping("/roleAdd")
	public String roleAdd(Model model){
		model.addAttribute("function", this.fs.query());
		return "jsp/RoleAdd";
	}
	@RequestMapping("/incomeAdd")
	public String incomeAdd(Model model,HttpSession session){
		try {
		Typee typee = new Typee();
		UserInfo userInfo = (UserInfo) session.getAttribute("User");
		typee.setUser_id(userInfo.getId());
		typee.setType("1");
		Family family = new Family();
		family.setUser_id(userInfo.getId());
			model.addAttribute("typeeList", this.typeeService.informationLoadAll(typee));
			model.addAttribute("familyList", this.familyService.informationLoadAll(family));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "jsp/IncomeAdd";
	}
	@RequestMapping("/outcomeAdd")
	public String outcomeAdd(Model model,HttpSession session){
		try {
			Typee typee = new Typee();
			UserInfo userInfo = (UserInfo) session.getAttribute("User");
			typee.setUser_id(userInfo.getId());
			typee.setType("2");
			Family family = new Family();
			family.setUser_id(userInfo.getId());
				model.addAttribute("typeeList", this.typeeService.informationLoadAll(typee));
				model.addAttribute("familyList", this.familyService.informationLoadAll(family));
			} catch (Exception e) {
				e.printStackTrace();
			}
		return "jsp/OutcomeAdd";
	}
	@RequestMapping("/familyAdd")
	public String familyAdd(){
		return "jsp/FamilyAdd";
	}
	@RequestMapping("/typeeAdd")
	public String typeeAdd(){
		return "jsp/TypeeAdd";
	}
	
	
	
	
	
	
	
	
	
}
