package com.mpogorzelski.app.technical_test.repository.data_source.local.base;
import com.mpogorzelski.app.technical_test.AssetsClient;
import com.mpogorzelski.app.technical_test.repository.data_source.DataSource;

/**
 * Created by mpogorzelskil on 10/04/2019.
 */

public abstract class LocalDataSource<Type> implements DataSource<Type> {
	
	protected AssetsClient<Type> assetsClient;
	protected Type dto;
	
	public LocalDataSource(AssetsClient<Type> assetsClient) {
		this.assetsClient = assetsClient;
	}
	
	protected abstract String getFileName();
	
	protected void loadFromAssets() {
		dto = assetsClient.get(getFileName());
	}
	
	@Override
	public Type get() {
		if (dto != null) {
			return dto;
		}
		loadFromAssets();
		return dto;
	}
	
	@Override
	public void set(Type type) {
		throw new UnsupportedOperationException("set operation is not available on this dataSource");
	}
	
	@Override
	public void remove() {
		throw new UnsupportedOperationException("remove operation is not available on this dataSource");
	}
}
