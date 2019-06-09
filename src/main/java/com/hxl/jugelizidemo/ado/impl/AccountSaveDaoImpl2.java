/**
 * 
 */
package com.hxl.jugelizidemo.ado.impl;

import com.hxl.jugelizidemo.ado.AccountSaveDao;
import org.springframework.stereotype.Repository;

/**
 * @author 0283000170
 *
 */
@Repository("accountSaveDao2")
public class AccountSaveDaoImpl2 implements AccountSaveDao {
	
	public void saveAccount(){
		System.out.println("Save Account2...!!!");
	}
}
