package com.mpogorzelski.app.technical_test.recycler_view.Item_view_model;
import android.content.Context;

/**
 * Created by mpogorzelskil on 11/04/2019.
 */

public abstract class ItemViewModel<T>  {
	
	protected T mItem;
	
	public ItemViewModel(Context context) { }
	
	public abstract void update(T item);
	
}
