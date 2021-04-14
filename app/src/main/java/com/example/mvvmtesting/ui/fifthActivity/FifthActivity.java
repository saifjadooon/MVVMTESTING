package com.example.mvvmtesting.ui.fifthActivity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import com.example.mvvmtesting.R;
import com.example.mvvmtesting.databinding.ActivityFifthBinding;
import com.example.mvvmtesting.ui.fourthActivity.FourthActivityOutputEvent;

import timber.log.Timber;

public class FifthActivity extends AppCompatActivity {

    ActivityFifthBinding activityFifthBinding;
    FifthActivityViewModel fifthActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

        fifthActivityViewModel = ViewModelProviders.of(this).get(FifthActivityViewModel.class);
        activityFifthBinding = ActivityFifthBinding.inflate(getLayoutInflater());
        setContentView(activityFifthBinding.getRoot());

        clickListeners();
        subscribeObservers();


    }

    private void subscribeObservers() {

        fifthActivityViewModel.LD.observe(this, s -> {

            if (s instanceof FifthActivityOutputEvent.notifyUser)
            {
                FifthActivityOutputEvent.notifyUser notifiyUser = (FifthActivityOutputEvent.notifyUser) s;
                Timber.d("Outout event is %s", notifiyUser.getEmail());
                notifiyUser.getPin();

                Toast.makeText(this, notifiyUser.getEmail(), Toast.LENGTH_LONG).show();
                Toast.makeText(this, notifiyUser.getPin(), Toast.LENGTH_LONG).show();
            }

        });
    }

    private void clickListeners() {

        activityFifthBinding.btnLogin.setOnClickListener(view -> {


            String email = activityFifthBinding.etEmail.getText().toString();
            String pin = activityFifthBinding.etPin.getText().toString();

            FifthActivityInputEvent.loginButtonClick loginButtonClick = new FifthActivityInputEvent.loginButtonClick();
            loginButtonClick.setEmail(email);
            loginButtonClick.setPin(pin);

            fifthActivityViewModel.setUpInputEventFifthActivity(loginButtonClick);
        });

    }
}