package com.georgia.tk.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.georgia.tk.emp.EmpService;
import com.georgia.tk.emp.EmpVO;

@Controller
//@RequestMapping("/emp/*")
public class EmpController {

	@Autowired
	private EmpService empService;

	@RequestMapping("/empList")
	public String empList(String page, EmpVO empVO, HttpServletRequest request) {
		if (page == null || page.equals("1")) {
			page = "1";
			empVO.setPage(0);
		} else {
			empVO.setPage((Integer.parseInt(page) - 1) * 20);
		}
		System.out.println("검색 게시물 페이지 : " + page);
		
		List<EmpVO> empList = empService.empList(empVO);

		int empListCount = empService.empListCount();
		System.out.println("총 게시물 수 : " + empListCount);

		int pageCnt = 0;
		if (empListCount % 20 == 0) {
			pageCnt = empListCount / 20;
		} else {
			pageCnt = empListCount / 20 + 1;
		}

		request.setAttribute("empList", empList);
		request.setAttribute("pageCnt", pageCnt);
		request.setAttribute("page", page);

		return "WEB-INF/views/emp/empList.jsp";
	}

	@RequestMapping("/empSearch")
	public String empSearch(@RequestParam(defaultValue = "") String empId,
			@RequestParam(defaultValue = "") String empName, @RequestParam(defaultValue = "") String empDepartment,
			@RequestParam(defaultValue = "") String empPosition, @RequestParam(defaultValue = "") String empHiredate,
			String page, EmpVO empVO, HttpServletRequest request) {
		
		if (page == null || page.equals("1")) {
			page = "1";
			empVO.setPage(0);
		} else {
			empVO.setPage((Integer.parseInt(page) - 1) * 20);
		}
		System.out.println("검색 게시물 페이지 : " + page);
		
		Map<String, Object> empSearchMap = new HashMap<String, Object>();
		empSearchMap.put("empId", empId);
		empSearchMap.put("empName", empName);
		empSearchMap.put("empDepartment", empDepartment);
		empSearchMap.put("empPosition", empPosition);
		empSearchMap.put("empHiredate", empHiredate);
		empSearchMap.put("page", empVO.getPage());
		
		int empListCount = empService.empSearchCount(empSearchMap);
		System.out.println("검색 게시물 수 : " + empListCount);

		int pageCnt = 0;
		if (empListCount % 20 == 0) {
			pageCnt = empListCount / 20;
		} else {
			pageCnt = empListCount / 20 + 1;
		}

		List<EmpVO> empList = empService.empList(empSearchMap);

		request.setAttribute("empList", empList);
		request.setAttribute("pageCnt", pageCnt);
		request.setAttribute("page", page);
		request.setAttribute("searchEmpId", empId);
		request.setAttribute("searchEmpName", empName);
		request.setAttribute("searchEmpDepartment", empDepartment);
		request.setAttribute("searchEmpPosition", empPosition);
		request.setAttribute("searchEmpHiredate", empHiredate);

		return "WEB-INF/views/emp/empSearchList.jsp";
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
	public String empDeleteAction(@RequestParam int emp_id) {
		empService.empDelete(emp_id);

		return "redirect:/empList";
	}

	@RequestMapping("/empCreatePage")
	public String empCreatePage(EmpVO empVO, HttpServletRequest request) {

		return "WEB-INF/views/emp/empCreate.jsp";
	}

	@RequestMapping("/empCreate")
	public String empCreate(@ModelAttribute EmpVO empVO, HttpServletRequest request) {

		System.out.println("sfdfsdf");
		System.out.println(empVO.getEmp_id());
		System.out.println(empVO.getEmp_name());
		System.out.println(empVO.getEmp_department());
		System.out.println(empVO.getEmp_position());
		System.out.println(empVO.getEmp_hiredate());
		System.out.println(empVO.getEmp_profit());
		System.out.println(empVO.getEmp_salary());

		empService.empCreate(empVO);

		return "empList";
	}

}