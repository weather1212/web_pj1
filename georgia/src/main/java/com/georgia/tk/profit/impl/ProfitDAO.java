package com.georgia.tk.profit.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProfitDAO {
	@Autowired
	public SqlSessionTemplate mybatis;
}
