package com.example.mvvmtesting.ui.secondActivity.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.mvvmtesting.databinding.FragmentCBinding;
import com.example.mvvmtesting.ui.secondActivity.SecondSharedViewModel;


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
    }
}