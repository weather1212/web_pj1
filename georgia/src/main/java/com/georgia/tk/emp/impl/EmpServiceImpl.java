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
	public List<EmpVO> empList(EmpVO empVO) {
		return empDAO.empList(empVO);
	}

	@Override
	public EmpVO empDetail(EmpVO empVO) {
		return empDAO.empDetail(empVO);
	}

	@Override
	public void empCreate(EmpVO empVO) {
		empDAO.empCreate(empVO);
	}

	@Override
	public void empUpdate(EmpVO empVO) {
		empDAO.empUpdate(empVO);		
	}

}
