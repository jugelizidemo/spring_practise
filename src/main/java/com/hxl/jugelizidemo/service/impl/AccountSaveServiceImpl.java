package com.hxl.jugelizidemo.service.impl;

import com.hxl.jugelizidemo.ado.AccountSaveDao;
import com.hxl.jugelizidemo.service.AccountSaveService;

public class AccountSaveServiceImpl implements AccountSaveService{
	
	private AccountSaveDao accountSaveDao ;

	public AccountSaveServiceImpl(){
		System.out.println("对象创建了!");
	}

	public void saveAccount(){
		//accountSaveDao.saveAccount();
		System.out.println("对象中的方法执行了!");
	}

	public void init(){
		System.out.println("对象初始化!");
	}

	public void destroy(){
		System.out.println("对象销毁了!");
	}
	
}
