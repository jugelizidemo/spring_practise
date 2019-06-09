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
@Repository("accountSaveDao1")
public class AccountSaveDaoImpl implements AccountSaveDao {
	
	public void saveAccount(){
		System.out.println("Save Account1...!!!");
	}
}
