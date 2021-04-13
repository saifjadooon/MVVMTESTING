package com.example.mvvmtesting.ui.main;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.mvvmtesting.VIEWMODELS.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    private com.example.mvvmtesting.databinding.ActivityMainBinding ActivityMainBinding;
    private MainActivityViewModel mainActivityViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //activity binding
        ActivityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(ActivityMainBinding.getRoot());

        //view model initializing
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        sClickListeners();
        hSubscribeObserver();
    }


    // we will use this to observe data change
    private void hSubscribeObserver() {
        mainActivityViewModel.sTextLD.observe(this, text -> {
           ActivityMainBinding.textView.setText(text);
        });
    }

    private void sClickListeners() {

        ActivityMainBinding.btnGetData.setOnClickListener(view -> {

            mainActivityViewModel.getDataButtonClicked();
        });


    }
}