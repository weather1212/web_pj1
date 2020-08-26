package com.georgia.tk.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.georgia.tk.emp.EmpService;
import com.georgia.tk.profit.ProfitService;
import com.georgia.tk.project.ProjectService;
@Controller
public class EmpController {
	@Autowired
	private EmpService empService;
	
	
	@RequestMapping("/test")
	public String test(HttpServletRequest request) {
		return "test.jsp";
	}
	
}
