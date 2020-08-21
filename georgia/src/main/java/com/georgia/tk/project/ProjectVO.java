package com.georgia.tk.project;

import java.util.Date;

import lombok.Data;

@Data
public class ProjectVO {
	int p_id;
	String p_name;
	String p_content;
	Date p_start;
	Date p_end;
	String p_state;
	int page;
}
