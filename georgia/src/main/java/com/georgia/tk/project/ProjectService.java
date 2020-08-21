package com.georgia.tk.project;

import java.util.List;

public interface ProjectService {
	public List<ProjectVO> listSelectProject();
	public ProjectVO oneSelectProject(ProjectVO projectVO);
	public void createProject(ProjectVO projectVO);
	public void updateProject(ProjectVO projectVO);
}
