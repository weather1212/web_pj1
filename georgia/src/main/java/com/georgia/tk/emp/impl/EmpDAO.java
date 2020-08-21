package com.georgia.tk.emp.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.georgia.tk.emp.EmpVO;

@Repository
public class EmpDAO {
	@Autowired
	public SqlSessionTemplate mybatis;
	
	public List<EmpVO> listSelectEmp(EmpVO empVO) {
		return null;
	}

	public EmpVO oneSelectEmp(EmpVO empVO) {
		return null;
	}
	
	public void createEmp(EmpVO empVO) {
		
	}

	public void updateEmp(EmpVO empVO) {
		
	}
}
