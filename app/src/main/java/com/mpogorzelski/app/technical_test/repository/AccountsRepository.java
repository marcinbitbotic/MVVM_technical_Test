package com.mpogorzelski.app.technical_test.repository;
import com.mpogorzelski.app.technical_test.data.Account;
import com.mpogorzelski.app.technical_test.data.AccountList;
import com.mpogorzelski.app.technical_test.repository.data_source.DataSource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mpogorzelskil on 13/04/2019.
 */

public class AccountsRepository extends Repository<AccountList> {
	
	public AccountsRepository(DataSource<AccountList> dataSource) {
		super(dataSource);
	}

	public AccountList getFilteredAccounts() {
		//FAKE Filter
		AccountList accountList = dataSource.get();
		List<Account> accounts = new ArrayList<>();
		for (Account account:accountList.getAccounts()) {
			if(account.isVisible()){
				accounts.add(account);
			}
		}
		accountList.setAccounts(accounts);
		return accountList;

	}
	
}
