package com.mpogorzelski.app.technical_test.recycler_view.Item_view_model;
import android.view.View;
import android.widget.TextView;

import com.mpogorzelski.app.technical_test.R;
import com.mpogorzelski.app.technical_test.data.Account;

/**
 * Created by mpogorzelskil on 15/04/2019.
 */

public class AccountViewModel extends ItemViewModel<Account> {
	
	public TextView iban;
	public TextView name;
	public TextView balance;
	public View itemView;
	
	public AccountViewModel(View itemView) {
		super(itemView.getContext());
		this.itemView = itemView;
		iban = itemView.findViewById(R.id.tv_iban);
	}
	
	@Override
	public void update(Account item) {
		iban.setText(item.getIban());
	}
}
