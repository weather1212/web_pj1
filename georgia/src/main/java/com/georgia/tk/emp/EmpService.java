package com.georgia.tk.emp;

import java.util.List;
import java.util.Map;

public interface EmpService {
	public List<EmpVO> empList(EmpVO empVO);
	public List<EmpVO> empList(Map<String, Object> empSearchMap);
	public EmpVO empDetail(int empId);
	public void empCreate(EmpVO empVO);
	public void empUpdate(EmpVO empVO);
	public void empDelete(int empId);
	public int empListCount();
	public int empSearchCount(Map<String, Object> empSearchMap);
}
