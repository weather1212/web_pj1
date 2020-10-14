package com.georgia.tk.project.impl;

import java.util.List;
import java.util.Map;

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
	public List<ProjectVO> projectList(Map<String, Object> projectSearchMap) {
		return projectDAO.projectList(projectSearchMap);
	}
	
	@Override
	public ProjectVO projectDetail(int projectId) {
		return projectDAO.projectDetail(projectId);
	}

	@Override
	public void projectCreate(ProjectVO projectVO) {
		projectDAO.projectCreate(projectVO);
	}

	@Override
	public void projectUpdate(ProjectVO projectVO) {
		projectDAO.projectUpdate(projectVO);
	}

	@Override
	public void projectDelete(int projectId) {
		projectDAO.projectDelete(projectId);
	}

	@Override
	public int projectListCount() {
		return projectDAO.projectListCount();
	}

	@Override
	public int projectSearchCount(Map<String, Object> projectSearchMap) {
		return projectDAO.projectSearchCount(projectSearchMap);
	}
}
