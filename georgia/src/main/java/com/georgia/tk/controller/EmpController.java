package com.georgia.tk.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.georgia.tk.emp.EmpService;
import com.georgia.tk.emp.EmpVO;
import com.georgia.tk.profit.ProfitService;
import com.georgia.tk.project.ProjectService;

@Controller
//@RequestMapping("/emp/*")
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
		List<EmpVO> empList = empService.empList(empVO);
		request.setAttribute("empList", empList);
		request.setAttribute("pageCnt", 2);
		request.setAttribute("page", page);
		return "WEB-INF/views/emp/empList.jsp";
	}
	
	@RequestMapping("/empDetail")
	public String empDetail(@RequestParam int empId, HttpServletRequest request) {
		EmpVO empVO = empService.empDetail(empId);
		request.setAttribute("empVO", empVO);
		
		return "WEB-INF/views/emp/empDetail.jsp";
	}
	
	@RequestMapping("/empUpdateAction")
	public String empUpdateAction(@ModelAttribute EmpVO empVO) {	
		empService.empUpdate(empVO);
		
		return "redirect:/empList";
	}
	@RequestMapping("/empDeleteAction")
	public String empDeleteAction(@RequestParam int empId) {	
		empService.empDelete(empId);
		
		return "redirect:/empList";
	}
	
//	@RequestMapping("/empDetailAction")
//	public String empDetailAction(EmpVO empVO, HttpServletRequest request) {
//		
//		
//		empVO.setEmp_id((Integer) request.getParameter("emp_id"));
//		empService.empDetail(empVO);
//		
//		
//		
//		return "WEB-INF/views/emp/empDetail.jsp";
//	}

	
	
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