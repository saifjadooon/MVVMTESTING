package com.example.mvvmtesting.ui.thirdActivity.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.mvvmtesting.databinding.FragmentGBinding;
import com.example.mvvmtesting.ui.secondActivity.SecondInputEvents;
import com.example.mvvmtesting.ui.secondActivity.SecondOutputEvents;
import com.example.mvvmtesting.ui.thirdActivity.ThirdActivityInputEvents;
import com.example.mvvmtesting.ui.thirdActivity.ThirdActivityOutputEvents;
import com.example.mvvmtesting.ui.thirdActivity.thirdActivitySharedViewModel;

import timber.log.Timber;

public class FragmentG extends Fragment {

    FragmentGBinding fragmentGBinding;
    private thirdActivitySharedViewModel thirdActivitySharedViewModel;


    public FragmentG() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        fragmentGBinding = fragmentGBinding.inflate(
                inflater,
                container,
                false
        );
        return fragmentGBinding.getRoot();


    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        thirdActivitySharedViewModel = ViewModelProviders.of(requireActivity()).get(thirdActivitySharedViewModel.class);

        hSubscribeObsers();

        hSetupListerns();
    }


    private void hSubscribeObsers() {
        thirdActivitySharedViewModel.thirdActivityOutputEventsLiveData.observe(
                getViewLifecycleOwner(),
                thirdActivityOutputEvents -> {
                    if (thirdActivityOutputEvents instanceof ThirdActivityOutputEvents.NotifyUser) {
                        ThirdActivityOutputEvents.NotifyUser notifiyUser = (ThirdActivityOutputEvents.NotifyUser) thirdActivityOutputEvents;
                        Timber.d("Outout event is %s", notifiyUser.getHmessage());
                        notifiyUser.getHmessage();

                        Toast.makeText(requireContext(), notifiyUser.getHmessage(), Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    private void hSetupListerns() {
        fragmentGBinding.btnGetData.setOnClickListener(view1 -> {

            ThirdActivityInputEvents.OnloginButtonClicked hOnLoginButtonClicked = new ThirdActivityInputEvents.OnloginButtonClicked();

            hOnLoginButtonClicked.sethText(fragmentGBinding.etText.getText().toString());

            thirdActivitySharedViewModel.setUpInputEvents(hOnLoginButtonClicked);
        });
    }
}