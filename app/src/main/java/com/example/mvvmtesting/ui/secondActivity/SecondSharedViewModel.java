package com.example.mvvmtesting.ui.secondActivity;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class SecondSharedViewModel extends AndroidViewModel {
    public SecondSharedViewModel(@NonNull Application application) {
        super(application);
        Log.d("test123", "View model initilized");
    }
}
