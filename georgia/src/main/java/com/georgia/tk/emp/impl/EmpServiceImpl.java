package com.georgia.tk.emp.impl;

import java.util.List;
import java.util.Map;

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
	public List<EmpVO> empList(Map<String, Object> empSearchMap) {
		return empDAO.empList(empSearchMap);
	}
	
	@Override
	public EmpVO empDetail(int empId) {
		return empDAO.empDetail(empId);
	}

	@Override
	public void empCreate(EmpVO empVO) {
		empDAO.empCreate(empVO);
	}

	@Override
	public void empUpdate(EmpVO empVO) {
		empDAO.empUpdate(empVO);		
	}

	@Override
	public void empDelete(int empId) {
		empDAO.empDelete(empId);
		
	}

	@Override
	public int empListCount() {
		return empDAO.empListCount();
	}

	@Override
	public int empSearchCount(Map<String, Object> empSearchMap) {
		return empDAO.empSearchCount(empSearchMap);
	}

}
