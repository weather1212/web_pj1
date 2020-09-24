package com.georgia.tk.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.georgia.tk.emp.EmpService;
import com.g0eorgia.tk.emp.EmpVO;
import com.georgia.tk.profit.ProfitService;
import com.georgia.tk.project.ProjectService;

@Controller
public class EmpController {
	@Autowired
	private EmpService empService;
	
	
	@RequestMapping("/empList")
	public String test(String page, EmpVO empVO, HttpServletRequest request) {
		if(page==null || page.equals("1")) {
			page="1";
			empVO.setPage(0);
		} else {
			empVO.setPage((Integer.parseInt(page)-1)*20);
		}
		List<EmpVO> empList = empService.listSelectEmp(empVO);
		request.setAttribute("empList", empList);
		request.setAttribute("pageCnt", 2);
		request.setAttribute("page", page);
		return "WEB-INF/views/emp/empList.jsp";
	}
	
	@RequestMapping("/empDetail")
	public String empDetail(EmpVO empVO, HttpServletRequest request) {
		

		
		return "WEB-INF/views/emp/empDetail.jsp";
	}
	
	@RequestMapping("/empCreatePage")
	public String empCreatePage(EmpVO empVO, HttpServletRequest request) {

		return "WEB-INF/views/emp/empCreate.jsp";
	}
	
	@RequestMapping("/empCreate")
	public String empCreate(EmpVO empVO, HttpServletRequest request) {

		return "empList";
	}
	
	@RequestMapping("/empSearch")
	public String empSearch(String page, EmpVO empVO, HttpServletRequest request) {

		return "WEB-INF/views/emp/empSearchList.jsp";
	}
	
}