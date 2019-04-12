package com.mpogorzelski.app.technical_test.repository;
import com.mpogorzelski.app.technical_test.data.AccountList;
import com.mpogorzelski.app.technical_test.repository.data_source.DataSource;

/**
 * Created by mpogorzelskil on 10/04/2019.
 */

public class AccountsRepository extends Repository<AccountList> {
	
	public AccountsRepository(DataSource<AccountList> dataSource) {
		super(dataSource);
	}
	
}
