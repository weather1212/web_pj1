package com.georgia.tk.project.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.georgia.tk.project.ProjectVO;
@Repository
public class ProjectDAO {
	@Autowired
	public SqlSessionTemplate mybatis;
	
	public List<ProjectVO> listSelectProject() {
		return mybatis.selectList("projectDAO.listSelectProject");
	}	
	
	public ProjectVO oneSelectProject(ProjectVO projectVO) {
		return mybatis.selectOne("projectDAO.oneSelectProject", projectVO);
	}
	
	public void createProject(ProjectVO projectVO) {
		mybatis.insert("projectDAO.createProject", projectVO);
	}

	public void updateProject(ProjectVO projectVO) {
		mybatis.update("projectDAO.updateProject", projectVO);
	}

}
