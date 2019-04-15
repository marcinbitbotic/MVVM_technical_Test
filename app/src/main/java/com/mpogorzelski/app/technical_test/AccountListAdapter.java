package com.mpogorzelski.app.technical_test;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mpogorzelski.app.technical_test.data.Account;
import com.mpogorzelski.app.technical_test.data.AccountList;
import com.mpogorzelski.app.technical_test.recycler_view.item_view_holder.AccountViewHolder;

/**
 * Created by mpogorzelskil on 11/04/2019.
 */

public class AccountListAdapter extends RecyclerView.Adapter<AccountViewHolder> {
	
	private AccountList accountList;
	
	@Override
	public AccountViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.item_account_layout, parent, false);
		return new AccountViewHolder(view.getContext(),view);
	}
	
	@Override
	public void onBindViewHolder(AccountViewHolder holder, int position) {
		Account account = accountList.getAccounts().get(position);
		holder.bind(account);
	}
	
	@Override
	public int getItemCount() {
		return accountList.getAccounts().size();
	}
	
	public void setData(AccountList movieList) {
		accountList = movieList;
		notifyDataSetChanged();
	}
	
	public void clearAdapter() {
		accountList.getAccounts().clear();
		notifyDataSetChanged();
	}
	
}
