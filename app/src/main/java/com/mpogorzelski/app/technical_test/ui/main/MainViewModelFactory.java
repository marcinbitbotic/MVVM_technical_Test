package com.mpogorzelski.app.technical_test.ui.main;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;

import com.mpogorzelski.app.technical_test.repository.AccountsRepository;

/**
 * Created by mpogorzelskil on 13/04/2019.
 */

public class MainViewModelFactory implements ViewModelProvider.Factory {
	
	private Context context;
	private AccountsRepository accountsRepository;
	
	
	public MainViewModelFactory(Context context, AccountsRepository accountsRepository) {
		this.context = context;
		this.accountsRepository = accountsRepository;
	}
	
	
	@Override
	public <T extends ViewModel> T create(Class<T> modelClass) {
		return (T) new MainViewModel(context, accountsRepository);
	}
	
}
