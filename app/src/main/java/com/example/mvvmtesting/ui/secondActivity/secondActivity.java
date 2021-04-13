package com.example.mvvmtesting.ui.secondActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.mvvmtesting.databinding.ActivityFragmentBinding;

public class secondActivity extends AppCompatActivity {

    private ActivityFragmentBinding hActivityFragmentBinding;

    private SecondSharedViewModel hSecondSharedViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        hActivityFragmentBinding = ActivityFragmentBinding.inflate(getLayoutInflater());
        setContentView(hActivityFragmentBinding.getRoot());


        hSecondSharedViewModel = ViewModelProviders.of(this).get(SecondSharedViewModel.class);
    }
}