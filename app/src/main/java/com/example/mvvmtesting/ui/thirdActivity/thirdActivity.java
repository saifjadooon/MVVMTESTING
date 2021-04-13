package com.example.mvvmtesting.ui.thirdActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.mvvmtesting.R;
import com.example.mvvmtesting.databinding.ActivityThirdBinding;

public class thirdActivity extends AppCompatActivity {


    private ActivityThirdBinding activityThirdBinding;
    private thirdActivitySharedViewModel thirdActivitySharedViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityThirdBinding = ActivityThirdBinding.inflate(getLayoutInflater());
        setContentView(activityThirdBinding.getRoot());

        thirdActivitySharedViewModel = ViewModelProviders.of(thirdActivity.this).get(thirdActivitySharedViewModel.class);
    }




}