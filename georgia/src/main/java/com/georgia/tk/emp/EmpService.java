package com.georgia.tk.emp;

import java.util.List;

public interface EmpService {
	public List<EmpVO> listSelectEmp(EmpVO empVO);
	public EmpVO oneSelectEmp(EmpVO empVO);
	public void createEmp(EmpVO empVO);
	public void updateEmp(EmpVO empVO);
}
