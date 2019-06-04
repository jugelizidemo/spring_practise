/**
 * 
 */
package com.hxl.jugelizidemo.ui;


import com.hxl.jugelizidemo.ado.AccountSaveDao;
import com.hxl.jugelizidemo.ado.impl.AccountSaveDaoImpl;
import com.hxl.jugelizidemo.service.AccountSaveService;
import com.hxl.jugelizidemo.service.impl.AccountSaveServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * 模拟表现层
 * 
 *
 * @author 0283000170	
 *
 */
public class UIClient {
		/*获取spring的ioc容器,并根据id获取对象*/
	public static void main(String[] args){
		//1.获取核心容器对象
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		//2.根据id获取bean对象
		AccountSaveService ass  = (AccountSaveService)ac.getBean("accountSaveService");
		AccountSaveDao aso = ac.getBean("acoountSaveDao", AccountSaveDao.class);
		System.out.println(ass.toString());
		System.out.println(aso.toString());
	}
	
}
