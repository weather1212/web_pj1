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
	public List<ProjectVO> listSelectProject() {
		return projectDAO.listSelectProject();
	}
	
	@Override
	public ProjectVO oneSelectProject(ProjectVO projectVO) {
		return projectDAO.oneSelectProject(projectVO);
	}
	
	@Override
	public void createProject(ProjectVO projectVO) {
		projectDAO.createProject(projectVO);
	}

	@Override
	public void updateProject(ProjectVO projectVO) {
		projectDAO.updateProject(projectVO);
	}
}
