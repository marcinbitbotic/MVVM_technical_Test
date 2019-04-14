package com.mpogorzelski.app.technical_test.repository.data_source;
/**
 * Created by mpogorzelskil on 13/04/2019.
 */

public interface DataSource<Type> {
	
	Type get();
	
	void load();
	
	void set(Type type);
	
	void remove();
}