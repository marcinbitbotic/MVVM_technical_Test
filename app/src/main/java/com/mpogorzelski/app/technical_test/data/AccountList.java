package com.mpogorzelski.app.technical_test.data;
import java.util.List;

/**
 * Created by mpogorzelskil on 10/04/2019.
 */

public class AccountList {
	
	private List<Account> accounts;
	
	public AccountList(List<Account> values) {
		this.accounts = values;
	}
	
	public List<Account> getAccounts() {
		return accounts;
	}
	
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
}
