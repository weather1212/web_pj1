package com.georgia.tk.emp;

import java.util.List;

public interface EmpService {
	public List<EmpVO> empList(EmpVO empVO);
	public EmpVO empDetail(int empId);
	public void empCreate(EmpVO empVO);
	public void empUpdate(EmpVO empVO);
	public void empDelete(int empId);
}
