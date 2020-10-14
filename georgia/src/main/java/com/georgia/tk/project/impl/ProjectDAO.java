package com.georgia.tk.project.impl;

import java.util.List;
import java.util.Map;

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
	
	public List<ProjectVO> projectList(Map<String, Object> projectSearchMap) {
		return mybatis.selectList("projectDAO.projectSearchList", projectSearchMap);
	}

	public ProjectVO projectDetail(int projectId) {
		return mybatis.selectOne("projectDAO.projectDetail", projectId);
	}

	public void projectCreate(ProjectVO projectVO) {
		mybatis.insert("projectDAO.projectCreate", projectVO);
	}

	public void projectUpdate(ProjectVO projectVO) {
		mybatis.insert("projectDAO.projectUpdate", projectVO);
	}

	public void projectDelete(int projectId) {
		mybatis.insert("projectDAO.projectDelete", projectId);
	}

	public int projectListCount() {
		return mybatis.selectOne("projectDAO.projectListCount");
	}

	public int projectSearchCount(Map<String, Object> projectSearchMap) {
		return mybatis.selectOne("projectDAO.projectSearchCount", projectSearchMap);
	}
}
