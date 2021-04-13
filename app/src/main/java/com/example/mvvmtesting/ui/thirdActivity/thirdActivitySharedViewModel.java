package com.example.mvvmtesting.ui.thirdActivity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import timber.log.Timber;

public class thirdActivitySharedViewModel extends AndroidViewModel {

    private MutableLiveData<ThirdActivityOutputEvents> thirdActivityOutputEventsMutableLiveData ;
    public LiveData<ThirdActivityOutputEvents> thirdActivityOutputEventsLiveData;

    public thirdActivitySharedViewModel(@NonNull Application application) {
        super(application);

        Init();

    }

    private void Init() {
        thirdActivityOutputEventsMutableLiveData = new MutableLiveData<>();
        thirdActivityOutputEventsLiveData = thirdActivityOutputEventsMutableLiveData;
    }

    public void setUpInputEvents(ThirdActivityInputEvents thirdActivityInputEvents)
    {
        if (thirdActivityInputEvents instanceof  ThirdActivityInputEvents.OnloginButtonClicked)
        {

            ThirdActivityInputEvents.OnloginButtonClicked events = (ThirdActivityInputEvents.OnloginButtonClicked) thirdActivityInputEvents;

            Timber.d("Error info recived, %s" , events.gethText());

            ThirdActivityOutputEvents.NotifyUser notifyUser = new ThirdActivityOutputEvents.NotifyUser(events.gethText());

            thirdActivityOutputEventsMutableLiveData.postValue(notifyUser);



        }

    }


}
