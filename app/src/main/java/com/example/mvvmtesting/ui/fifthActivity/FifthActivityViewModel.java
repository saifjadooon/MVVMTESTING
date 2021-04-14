package com.example.mvvmtesting.ui.fifthActivity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class FifthActivityViewModel extends AndroidViewModel {

    private MutableLiveData<FifthActivityOutputEvent> MLD = new MutableLiveData<>();
    public LiveData<FifthActivityOutputEvent> LD;

    public FifthActivityViewModel(@NonNull Application application) {
        super(application);

        initViews();
    }

    private void initViews() {
        LD = MLD;
    }

    public void setUpInputEventFifthActivity(FifthActivityInputEvent fifthActivityInputEvent) {

        if (fifthActivityInputEvent instanceof FifthActivityInputEvent.loginButtonClick) {

            FifthActivityInputEvent.loginButtonClick events = (FifthActivityInputEvent.loginButtonClick) fifthActivityInputEvent;
            FifthActivityOutputEvent.notifyUser notifyUser = new FifthActivityOutputEvent.notifyUser();
            notifyUser.notifyUser(events.getEmail(), events.getPin());
            MLD.postValue(notifyUser);
        }

    }

}
