package com.example.mvvmtesting.ui.secondActivity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import timber.log.Timber;

public class SecondSharedViewModel extends AndroidViewModel {

    private MutableLiveData<SecondOutputEvents> hSecondOutputEventsMutableLiveData;
    public LiveData<SecondOutputEvents> hSecondOutputEventsLiveData;

    public SecondSharedViewModel(@NonNull Application application) {
        super(application);
        hInit();
        Timber.d("View model initilized");
    }

    private void hInit() {
        hSecondOutputEventsMutableLiveData = new MutableLiveData<>();
        hSecondOutputEventsLiveData = hSecondOutputEventsMutableLiveData;

    }

    public void hSetInputEvents(SecondInputEvents secondInputEvents) {
        if (secondInputEvents instanceof SecondInputEvents.OnLoginButtonClicked) {
            SecondInputEvents.OnLoginButtonClicked events = (SecondInputEvents.OnLoginButtonClicked) secondInputEvents;

            Timber.d("Error info recived, %s", events.hGetErrroInfo());


            Timber.d("INput recived, %s", events.hGetText());


            SecondOutputEvents.NotifiyUser notifiyUser = new SecondOutputEvents.NotifiyUser(events.hGetErrroInfo());

            hSecondOutputEventsMutableLiveData.postValue(notifiyUser);

        }



    }
}
