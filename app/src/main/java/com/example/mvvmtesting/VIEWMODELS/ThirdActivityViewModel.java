package com.example.mvvmtesting.VIEWMODELS;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class ThirdActivityViewModel extends AndroidViewModel {

    private MutableLiveData<String> MLD = new MutableLiveData<>();
    public LiveData<String> LD;
    public ThirdActivityViewModel(@NonNull Application application) {
        super(application);

        InitVariables();
    }

    private void InitVariables() {

        LD = MLD;
    }

    public void btnGetDataClicked()
    {

        getsecondApiData();

    }

    private void getsecondApiData() {
    }

    @Override
    protected void onCleared() {
        super.onCleared();

    }

}
