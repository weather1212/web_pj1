package com.georgia.tk.project;

import java.util.List;

public interface ProjectService {
	public List<ProjectVO> projectList(ProjectVO projectVO);
	public ProjectVO projectDetail(ProjectVO projectVO);
	public void projectCreate(ProjectVO projectVO);
	public void projectUpdate(ProjectVO projectVO);
}
