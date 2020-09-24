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

	public List<ProjectVO> projectList(ProjectVO projectVO) {
		return mybatis.selectList("projectDAO.projectList", projectVO);
	}

	public ProjectVO projectDetail(ProjectVO projectVO) {
		return mybatis.selectOne("projectDAO.projectDetail", projectVO);
	}

	public void projectCreate(ProjectVO projectVO) {
		mybatis.insert("projectDAO.projectCreate", projectVO);
	}

	public void projectUpdate(ProjectVO projectVO) {
		mybatis.insert("projectDAO.projectUpdate", projectVO);
	}
}
