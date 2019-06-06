package com.hxl.jugelizidemo.factory;

import com.hxl.jugelizidemo.service.AccountSaveService;
import com.hxl.jugelizidemo.service.impl.AccountSaveServiceImpl;

/*
* 模拟工厂类,该类可能存在与jar中,无法通过修改源码的形式得到默认构造函数*/
public class InstanceFactory {

    public AccountSaveService getService(){
        return new AccountSaveServiceImpl();
    }
}
