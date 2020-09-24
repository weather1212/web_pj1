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
	

	public List<EmpVO> empList(EmpVO empVO) {
		return mybatis.selectList("empDAO.empList", empVO);
	}

	public EmpVO empDetail(EmpVO empVO) {
		return mybatis.selectOne("empDAO.empDetail", empVO);
	}
	
	public void empCreate(EmpVO empVO) {
		mybatis.insert("empDAO.empCreate", empVO);
	}

	public void empUpdate(EmpVO empVO) {
		mybatis.insert("empDAO.empUpdate", empVO);
	}
}
