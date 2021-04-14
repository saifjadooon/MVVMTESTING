package com.example.mvvmtesting.ui.fourthActivity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.mvvmtesting.databinding.ActivityFourthBinding;

import timber.log.Timber;

public class fourthActivity extends AppCompatActivity {

    ActivityFourthBinding activityFourthBinding;
    private FourthActivitySharedViewModel fourthActivitySharedViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityFourthBinding = ActivityFourthBinding.inflate(getLayoutInflater());
        setContentView(activityFourthBinding.getRoot());

        fourthActivitySharedViewModel = ViewModelProviders.of(this).get(FourthActivitySharedViewModel.class);


        hSubscribeObsers();
        clickListeners();


    }


    //todo: sending datafrom view to view model
    private void clickListeners() {
        activityFourthBinding.btnReqData.setOnClickListener(view -> {

            String number = activityFourthBinding.tvShowData.getText().toString();
            FourthActivityInputEvent.loginButtonClick loginButtonClick = new FourthActivityInputEvent.loginButtonClick();
            loginButtonClick.setNumber(number);

            fourthActivitySharedViewModel.setUpInputEventFourthActivity(loginButtonClick);

        });
    }

    //todo: recieving data to view from viewmodel

    private void hSubscribeObsers() {
        fourthActivitySharedViewModel.LD.observe(
                this,
                fourthActivityOutputEvent -> {
                    if (fourthActivityOutputEvent instanceof FourthActivityOutputEvent.notifyUser) {
                        FourthActivityOutputEvent.notifyUser notifiyUser = (FourthActivityOutputEvent.notifyUser) fourthActivityOutputEvent;
                        Timber.d("Outout event is %s", notifiyUser.getNumber());
                        notifiyUser.getNumber();

                        Toast.makeText(this, notifiyUser.getNumber(), Toast.LENGTH_LONG).show();
                    }
                }
        );

    }
}