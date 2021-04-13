package com.example.mvvmtesting.ui.secondActivity.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.mvvmtesting.databinding.FragmentCBinding;
import com.example.mvvmtesting.ui.secondActivity.SecondInputEvents;
import com.example.mvvmtesting.ui.secondActivity.SecondOutputEvents;
import com.example.mvvmtesting.ui.secondActivity.SecondSharedViewModel;

import timber.log.Timber;


public class FragmentC extends Fragment {

    FragmentCBinding fragmentCBinding;
    private SecondSharedViewModel hSecondSharedViewModel;

    public FragmentC() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentCBinding = FragmentCBinding.inflate(
                inflater,
                container,
                false
        );
        /*This is jst a test*/
        return fragmentCBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        hSecondSharedViewModel = ViewModelProviders.of(requireActivity()).get(SecondSharedViewModel.class);

        hSubscribeObsers();
        hSetupListerns();
    }

    private void hSubscribeObsers() {
        hSecondSharedViewModel.hSecondOutputEventsLiveData.observe(
                getViewLifecycleOwner(),
                secondOutputEvents -> {
                    if (secondOutputEvents instanceof SecondOutputEvents.NotifiyUser) {
                        SecondOutputEvents.NotifiyUser notifiyUser = (SecondOutputEvents.NotifiyUser) secondOutputEvents;
                        Timber.d("Outout event is %s", notifiyUser.hGetMessage());
                        notifiyUser.hGetMessage();

                        Toast.makeText(requireContext(), notifiyUser.hGetMessage(), Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    private void hSetupListerns() {
        fragmentCBinding.hLoingB.setOnClickListener(view1 -> {

            SecondInputEvents.OnLoginButtonClicked hOnLoginButtonClicked = new SecondInputEvents.OnLoginButtonClicked();
            hOnLoginButtonClicked.hSetUserName(fragmentCBinding.hNameTv.getText().toString());

            hSecondSharedViewModel.hSetInputEvents(hOnLoginButtonClicked);
        });
    }
}