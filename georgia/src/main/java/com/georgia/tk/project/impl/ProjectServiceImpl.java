package com.georgia.tk.project.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.georgia.tk.project.ProjectService;
import com.georgia.tk.project.ProjectVO;
@Service
public class ProjectServiceImpl implements ProjectService{
	@Autowired
	private ProjectDAO projectDAO;
	
	@Override
	public List<ProjectVO> projectList(ProjectVO projectVO) {
		return projectDAO.projectList(projectVO);
	}

	@Override
	public ProjectVO projectDetail(ProjectVO projectVO) {
		return projectDAO.projectDetail(projectVO);
	}

	@Override
	public void projectCreate(ProjectVO projectVO) {
		projectDAO.projectCreate(projectVO);
	}

	@Override
	public void projectUpdate(ProjectVO projectVO) {
		projectDAO.projectUpdate(projectVO);
	}
}
