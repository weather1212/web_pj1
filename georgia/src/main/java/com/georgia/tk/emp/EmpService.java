package com.georgia.tk.emp;

import java.util.List;
sdfg
public interface EmpService {
	public List<EmpVO> empList(EmpVO empVO);
	public EmpVO empDetail(EmpVO empVO);
	public void empCreate(EmpVO empVO);
	public void empUpdate(EmpVO empVO);
}
