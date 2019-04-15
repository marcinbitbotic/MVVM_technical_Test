package com.mpogorzelski.app.technical_test.recycler_view.item_view_holder;
import android.content.Context;
import android.view.View;

import com.mpogorzelski.app.technical_test.data.Account;
import com.mpogorzelski.app.technical_test.recycler_view.Item_view_model.AccountViewModel;

/**
 * Created by mpogorzelskil on 15/04/2019.
 */

public class AccountViewHolder extends HolderViewModel<Account,AccountViewModel>  {
	
	public AccountViewHolder(Context context, View view) {
		super(context, view);
	}
	
	@Override
	protected AccountViewModel createViewModel() {
		return new AccountViewModel(itemView);
	}
}
