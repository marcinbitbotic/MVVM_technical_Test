package com.mpogorzelski.app.technical_test.ui.main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.mpogorzelski.app.technical_test.data.AccountList;
import com.mpogorzelski.app.technical_test.data.FilterType;
import com.mpogorzelski.app.technical_test.repository.AccountsRepository;

public class MainViewModel extends ViewModel {
	
	// TODO: Implement the ViewModel
	private Context context;
	private AccountsRepository accountsRepository;
	private LiveData<AccountList> accountListData;
	private MutableLiveData<FilterType> modelFilter;
	
	public MainViewModel(Context context, AccountsRepository accountsRepository) {
		this.context = context;
		this.accountsRepository = accountsRepository;
		modelFilter = new MutableLiveData<>();
		seTransformations();
		loadAccounts();
	}

	public void seTransformations() {
		accountListData =Transformations.switchMap(modelFilter,
				new android.arch.core.util.Function<FilterType, LiveData<AccountList>>() {
					@Override
					public LiveData<AccountList> apply(FilterType filterState) {

						MutableLiveData<AccountList> output = new MutableLiveData<>();
						accountsRepository.load();

						switch (filterState){
							default:
							case ALL:
								output.setValue(accountsRepository.get());
								break;

							case ONLY_VISIBLE:
								output.setValue(accountsRepository.getFilteredAccounts());
								break;

						}
						return output;
					}
				});
	}
	
	public void loadAccounts() {
		modelFilter.postValue(FilterType.ALL);
	}
	
	public void filterAccounts(FilterType filterType){
		modelFilter.postValue(filterType);
	}
	
	public LiveData<AccountList> getAccountListData() {
		return accountListData;
	}
	
}
