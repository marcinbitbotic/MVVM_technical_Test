package com.mpogorzelski.app.technical_test.recycler_view.item_view_holder;
import android.content.Context;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mpogorzelski.app.technical_test.recycler_view.Item_view_model.ItemViewModel;

/**
 * Created by mpogorzelskil on 11/04/2019.
 */

public abstract class HolderViewModel<T, VM extends ItemViewModel> extends RecyclerView.ViewHolder {
	
	protected Context mContext;
	protected VM mViewModel;
	
	protected abstract VM createViewModel();
	
	public HolderViewModel(Context context, View view) {
		super(view);
		mContext = context;
		mViewModel = createViewModel();
	}
	
	public final void bind(T item) {
		mViewModel.update(item);
	}
}