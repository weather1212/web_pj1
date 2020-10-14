package com.georgia.tk.project;

import java.util.List;
import java.util.Map;

public interface ProjectService {
	public List<ProjectVO> projectList(ProjectVO projectVO);
	public List<ProjectVO> projectList(Map<String, Object> projectSearchMap);
	public ProjectVO projectDetail(int projectId);
	public void projectCreate(ProjectVO projectVO);
	public void projectUpdate(ProjectVO projectVO);
	public void projectDelete(int projectId);
	public int projectListCount();
	public int projectSearchCount(Map<String, Object> projectSearchMap);
}
