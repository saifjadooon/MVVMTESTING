package com.example.mvvmtesting.ui.fourthActivity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class FourthActivitySharedViewModel extends AndroidViewModel {

    private MutableLiveData<FourthActivityOutputEvent> MLD = new MutableLiveData<>();
    public LiveData<FourthActivityOutputEvent> LD;

    public FourthActivitySharedViewModel(@NonNull Application application) {
        super(application);

        init();


    }

    private void init() {
        LD = MLD;
    }

    public void setUpInputEventFourthActivity(FourthActivityInputEvent fourthActivityInputEvent) {

        if (fourthActivityInputEvent instanceof FourthActivityInputEvent.loginButtonClick) {

            FourthActivityInputEvent.loginButtonClick events = (FourthActivityInputEvent.loginButtonClick) fourthActivityInputEvent;

            FourthActivityOutputEvent.notifyUser notifyUser = new FourthActivityOutputEvent.notifyUser();
            notifyUser.notifyUser(events.getNumber());

            MLD.postValue(notifyUser);

        }

    }


}
