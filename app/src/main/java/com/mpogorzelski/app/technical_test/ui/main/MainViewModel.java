package com.mpogorzelski.app.technical_test.ui.main;

import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.mpogorzelski.app.technical_test.data.Account;
import com.mpogorzelski.app.technical_test.data.AccountList;
import com.mpogorzelski.app.technical_test.data.FilterType;
import com.mpogorzelski.app.technical_test.repository.AccountsRepository;

public class MainViewModel extends ViewModel {
	
	// TODO: Implement the ViewModel
	private Context context;
	private AccountsRepository accountsRepository;
	private MutableLiveData<AccountList> accountListData;
	
	public MainViewModel(Context context, AccountsRepository accountsRepository) {
		this.context = context;
		this.accountsRepository = accountsRepository;
		this.accountListData = new MutableLiveData<>();
		loadAccounts();
	}
	
	public void loadAccounts() {
		accountsRepository.load();
		//accountListData.postValue when you call from background thread
		accountListData.setValue(accountsRepository.get());
	}
	
	private void filterAccounts(FilterType filterType){
		
		MutableLiveData<Account> accountListMutableLiveData = new MutableLiveData<>();
		
		/*
		accountListData = Transformations.switchMap(accountListMutableLiveData, input -> input.isVisible());
		LiveData<AccountList>.switchMap
		*/
	}
	
	public LiveData<AccountList> getAccountListData() {
		return accountListData;
	}
	
	/*
	public void setAccountsDataList(List<Account> accountList) {
		action = ACTION_ADD_ALL;
		questionDataList.clear();
		questionDataList.addAll(questionCardDatas);
	}
	*/
}
