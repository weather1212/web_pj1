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

import com.georgia.tk.project.ProjectService;
import com.georgia.tk.project.ProjectVO;

@Controller
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@RequestMapping("/projectList")
	public String projectList(String page, ProjectVO projectVO, HttpServletRequest request) {
		if (page == null || page.equals("1")) {
			page = "1";
			projectVO.setPage(0);
		} else {
			projectVO.setPage((Integer.parseInt(page) - 1) * 10);
		}
		System.out.println("현재 게시물 페이지 : " + page);

		int projectListCount = projectService.projectListCount();
		System.out.println("총 게시물 수 : " + projectListCount);

		int pageCnt = 0;
		if (projectListCount % 10 == 0) {
			pageCnt = projectListCount / 10;
		} else {
			pageCnt = projectListCount / 10 + 1;
		}

		List<ProjectVO> projectList = projectService.projectList(projectVO);

		request.setAttribute("projectList", projectList);
		request.setAttribute("pageCnt", pageCnt);
		request.setAttribute("page", page);

		return "WEB-INF/views/project/projectList.jsp";
	}

	@RequestMapping("/projectSearch")
	public String projectSearch(@RequestParam(defaultValue = "") String projectState,
			@RequestParam(defaultValue = "") String projectName, @RequestParam(defaultValue = "") String projectContent,
			@RequestParam(defaultValue = "") String projectStart, @RequestParam(defaultValue = "") String projectEnd,
			String page, ProjectVO projectVO, HttpServletRequest request) {

		if (page == null || page.equals("1")) {
			page = "1";
			projectVO.setPage(0);
		} else {
			projectVO.setPage((Integer.parseInt(page) - 1) * 10);
		}
		System.out.println("검색 게시물 페이지 : " + page);

		Map<String, Object> projectSearchMap = new HashMap<String, Object>();
		projectSearchMap.put("projectState", projectState);
		projectSearchMap.put("projectName", projectName);
		projectSearchMap.put("projectContent", projectContent);
		projectSearchMap.put("projectStart", projectStart);
		projectSearchMap.put("projectEnd", projectEnd);
		projectSearchMap.put("page", projectVO.getPage());

		int projectListCount = projectService.projectSearchCount(projectSearchMap);
		System.out.println("검색 게시물 수 : " + projectListCount);

		int pageCnt = 0;
		if (projectListCount % 10 == 0) {
			pageCnt = projectListCount / 10;
		} else {
			pageCnt = projectListCount / 10 + 1;
		}

		List<ProjectVO> projectList = projectService.projectList(projectSearchMap);

		request.setAttribute("projectList", projectList);
		request.setAttribute("pageCnt", pageCnt);
		request.setAttribute("page", page);
		request.setAttribute("searchProjectState", projectState);
		request.setAttribute("searchProjectName", projectName);
		request.setAttribute("searchProjectContent", projectContent);
		request.setAttribute("searchProjectStart", projectStart);
		request.setAttribute("searchProjectEnd", projectEnd);

		return "WEB-INF/views/project/projectSearchList.jsp";
	}

	@RequestMapping("/projectDetail")
	public String projectDetail(@RequestParam int projectId, HttpServletRequest request) {
		ProjectVO projectVO = projectService.projectDetail(projectId);
		request.setAttribute("projectVO", projectVO);

		return "WEB-INF/views/project/projectDetail.jsp";
	}

	@RequestMapping("/projectUpdateAction")
	public String projectUpdateAction(@ModelAttribute ProjectVO projectVO) {
		projectService.projectUpdate(projectVO);

		return "redirect:/projectList";
	}

	@RequestMapping("/projectDeleteAction")
	public String projectDeleteAction(@RequestParam int p_id) {
		projectService.projectDelete(p_id);

		return "redirect:/projectList";
	}

	@RequestMapping("/projectCreatePage")
	public String projectCreatePage(ProjectVO projectVO, HttpServletRequest request) {

		return "WEB-INF/views/project/projectCreate.jsp";
	}

	@RequestMapping("/projectCreate")
	public String projectCreate(@ModelAttribute ProjectVO projectVO, HttpServletRequest request) {

		System.out.println("sfdfsdf");
		System.out.println(projectVO.getP_id());
		System.out.println(projectVO.getP_name());
		System.out.println(projectVO.getP_content());
		System.out.println(projectVO.getP_start());
		System.out.println(projectVO.getP_end());
		System.out.println(projectVO.getP_state());

		projectService.projectCreate(projectVO);

		return "projectList";
	}
}
