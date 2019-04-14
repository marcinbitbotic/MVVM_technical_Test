package com.mpogorzelski.app.technical_test.repository.data_source.local;
import com.mpogorzelski.app.technical_test.AssetsClient;
import com.mpogorzelski.app.technical_test.data.AccountList;
import com.mpogorzelski.app.technical_test.repository.data_source.local.base.LocalDataSource;

/**
 * Created by mpogorzelskil on 13/04/2019.
 */

public class AccountsDataSource extends LocalDataSource<AccountList> {
	
	private static final String FILE_NAME = "accounts.json";
	
	public AccountsDataSource(AssetsClient<AccountList> assetsClient) {
		super(assetsClient);
	}
	
	@Override
	protected String getFileName() {
		return FILE_NAME;
	}
	
	@Override
	public void load() {
		this.dto = null;
		loadFromAssets();
	}
}
