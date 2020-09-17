package com.georgia.tk.emp.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.georgia.tk.emp.EmpService;
import com.georgia.tk.emp.EmpVO;
@Service
public class EmpServiceImpl implements EmpService{
	@Autowired
	private EmpDAO empDAO;
	
	@Override
	public List<EmpVO> listSelectEmp(EmpVO empVO) {
		return empDAO.listSelectEmp(empVO);
	}

	@Override
	public EmpVO oneSelectEmp(EmpVO empVO) {
		return null;
	}
	
	@Override
	public void createEmp(EmpVO empVO) {
		
	}

	@Override
	public void updateEmp(EmpVO empVO) {
		
	}

}
