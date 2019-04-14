package com.mpogorzelski.app.technical_test.repository;
import com.mpogorzelski.app.technical_test.repository.data_source.DataSource;

/**
 * Created by mpogorzelskil on 13/04/2019.
 */

public abstract class Repository<DataSourceType> {
	
	protected final DataSource<DataSourceType> dataSource;
	
	public Repository(DataSource<DataSourceType> dataSource) {
		this.dataSource = dataSource;
	}
	
	public void load() {
		dataSource.load();
	}
	
	public DataSourceType get() {
		return dataSource.get();
	}
	
	public void set(DataSourceType raw) {
		dataSource.set(raw);
	}
	
	public void remove() {
		dataSource.remove();
	}
}
