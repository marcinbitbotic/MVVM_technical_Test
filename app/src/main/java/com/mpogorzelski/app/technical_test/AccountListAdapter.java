package com.mpogorzelski.app.technical_test;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mpogorzelski.app.technical_test.data.Account;
import com.mpogorzelski.app.technical_test.data.AccountList;

/**
 * Created by mpogorzelskil on 11/04/2019.
 */

public class AccountListAdapter extends RecyclerView.Adapter<AccountListAdapter.MovieViewHolder> {
	
	private AccountList accountList;
	
	@Override
	public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.item_account_layout, parent, false);
		return new MovieViewHolder(view);
	}
	
	@Override
	public void onBindViewHolder(MovieViewHolder holder, int position) {
		Account account = accountList.getAccounts().get(position);
		holder.iban.setText(account.getIban());
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
	
	
	/**
	 * ViewHolder class
	 */
	public class MovieViewHolder extends RecyclerView.ViewHolder {
		
		
		public TextView iban;
		public TextView name;
		public TextView balance;
		public View itemView;
		
		public MovieViewHolder(View itemView) {
			super(itemView);
			this.itemView = itemView;
			iban = itemView.findViewById(R.id.tv_iban);
		}
	}
	
	
}
