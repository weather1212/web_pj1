package com.georgia.tk.profit.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.georgia.tk.profit.ProfitService;

@Service
public class ProfitServiceImpl implements ProfitService{
	@Autowired
	private ProfitDAO profitDAO;
}
