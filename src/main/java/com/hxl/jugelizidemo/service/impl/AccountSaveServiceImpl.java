package com.hxl.jugelizidemo.service.impl;

import com.hxl.jugelizidemo.ado.AccountSaveDao;
import com.hxl.jugelizidemo.ado.impl.AccountSaveDaoImpl;
import com.hxl.jugelizidemo.service.AccountSaveService;

public class AccountSaveServiceImpl implements AccountSaveService{
	
	private AccountSaveDao accountSaveDao ;

	private AccountSaveServiceImpl(){
		System.out.println("对象创建了!");
	}
	public void saveAccount(){
		//accountSaveDao.saveAccount();
		System.out.println("AccountSaveServiceImpl 中的方法执行了!!!");
	}
	
}
