package com.hxl.jugelizidemo.service.impl;

import com.hxl.jugelizidemo.ado.AccountSaveDao;
import com.hxl.jugelizidemo.ado.impl.AccountSaveDaoImpl;
import com.hxl.jugelizidemo.service.AccountSaveService;

public class AccountSaveServiceImpl implements AccountSaveService{
	
	private AccountSaveDao accountSaveDao = new AccountSaveDaoImpl();

	public void saveAccount(){
		accountSaveDao.saveAccount();
	}
	
}
