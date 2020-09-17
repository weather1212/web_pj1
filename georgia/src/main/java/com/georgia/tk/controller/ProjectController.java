package com.georgia.tk.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.georgia.tk.emp.EmpService;
import com.georgia.tk.profit.ProfitService;
import com.georgia.tk.project.ProjectService;
import com.georgia.tk.project.ProjectVO;
@Controller
public class ProjectController {
	@Autowired
	private EmpService empService;
	@Autowired
	private ProfitService profitService;
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping("/projectList")
	public String projectList(String page, ProjectVO projectVO, HttpServletRequest request) {
		if(page==null || page.equals("1")) {
			page="1";
			projectVO.setPage(0);
		} else {
			projectVO.setPage((Integer.parseInt(page)-1)*20);
		}
		List<ProjectVO> projectList = projectService.projectList(projectVO);
		request.setAttribute("projectList", projectList);
		request.setAttribute("pageCnt", 2);
		request.setAttribute("page", page);
		return "WEB-INF/views/project/projectList.jsp";
	}
	
	@RequestMapping("/projectCreatePage")
	public String projectCreatePage(ProjectVO projectVO, HttpServletRequest request) {

		return "WEB-INF/views/project/projectCreate.jsp";
	}
	
	@RequestMapping("/projectCreate")
	public String projectCreate(ProjectVO projectVO, HttpServletRequest request) {

		return "projectList";
	}
	
	@RequestMapping("/projectSearch")
	public String projectSearch(String page, ProjectVO projectVO, HttpServletRequest request) {

		return "WEB-INF/views/project/projectSearchList.jsp";
	}
	
	@RequestMapping("/projectDetail")
	public String projectDetail(ProjectVO projectVO, HttpServletRequest request) {

		return "WEB-INF/views/project/projectDetail.jsp";
	}
}
