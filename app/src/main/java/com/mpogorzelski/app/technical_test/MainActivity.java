package com.mpogorzelski.app.technical_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mpogorzelski.app.technical_test.ui.main.MainFragment;
import com.mpogorzelski.app.technical_test.utils.NavigationController;

public class MainActivity extends AppCompatActivity {
    
    private NavigationController navigationController;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        navigationController = new NavigationController(this,R.id.container);
        if (savedInstanceState == null) {
            navigationController.navigateToAccountListFragment();
        }
    
        // Being here means we are in animation mode
        supportPostponeEnterTransition();
    }
}
