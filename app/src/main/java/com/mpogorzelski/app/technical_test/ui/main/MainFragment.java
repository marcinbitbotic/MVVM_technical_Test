package com.mpogorzelski.app.technical_test.ui.main;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.mpogorzelski.app.technical_test.AccountListAdapter;
import com.mpogorzelski.app.technical_test.AssetsClient;
import com.mpogorzelski.app.technical_test.JsonParser;
import com.mpogorzelski.app.technical_test.R;
import com.mpogorzelski.app.technical_test.data.AccountList;
import com.mpogorzelski.app.technical_test.repository.AccountsRepository;
import com.mpogorzelski.app.technical_test.repository.data_source.local.AccountsDataSource;

public class MainFragment extends Fragment {
    
    public static MainFragment newInstance() {
        return new MainFragment();
    }
    
    private MainViewModel mViewModel;
    private AccountListAdapter mAdapter;
    private RecyclerView mRecyclerView;
    
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }
    
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = view.findViewById(R.id.recyclerView);
        setUpRecyclerView();
    }
    
    private void setUpRecyclerView(){
        mAdapter = new AccountListAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
    
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // should use Dagger
        AssetsClient assetsClient = new AssetsClient<>(getContext(), new JsonParser<AccountList>(new Gson(),AccountList.class));
        mViewModel = ViewModelProviders.of(this,new MainViewModelFactory(getContext(),new AccountsRepository(new AccountsDataSource(assetsClient)))).get(MainViewModel.class);
        // TODO: Use the ViewModel
        observeViewModel(mViewModel);
    }
    
    private void observeViewModel(MainViewModel viewModel) {
        // Update the list when the data changes
        viewModel.getAccountListData().observe(this, new Observer<AccountList>() {
            @Override
            public void onChanged(@Nullable AccountList accountList) {
                if (accountList != null) {
                    mAdapter.setData(accountList);
                    //mAdapter.notifyDataSetChanged();
                }
            }
        });
    }
    
}
