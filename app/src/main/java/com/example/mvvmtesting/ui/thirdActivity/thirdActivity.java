package com.example.mvvmtesting.ui.thirdActivity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.mvvmtesting.R;
import com.example.mvvmtesting.VIEWMODELS.ThirdActivityViewModel;
import com.example.mvvmtesting.databinding.ActivityThirdBinding;

public class thirdActivity extends AppCompatActivity {


    private ActivityThirdBinding activityThirdBinding;
    private ThirdActivityViewModel thirdActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        activityThirdBinding = ActivityThirdBinding.inflate(getLayoutInflater());
        setContentView(activityThirdBinding.getRoot());

        thirdActivityViewModel = ViewModelProviders.of(thirdActivity.this).get(ThirdActivityViewModel.class);

        clickListeners();


    }

    private void clickListeners() {

        activityThirdBinding.btnGetData.setOnClickListener(view -> {

        });
    }

}