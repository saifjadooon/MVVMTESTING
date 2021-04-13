package com.example.mvvmtesting.ui.thirdActivity.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvvmtesting.R;
import com.example.mvvmtesting.databinding.FragmentHBinding;
import com.example.mvvmtesting.ui.secondActivity.SecondSharedViewModel;
import com.example.mvvmtesting.ui.thirdActivity.thirdActivity;
import com.example.mvvmtesting.ui.thirdActivity.thirdActivitySharedViewModel;

public class FragmentH extends Fragment {

    FragmentHBinding fragmentHBinding;
    private thirdActivitySharedViewModel thirdActivitySharedViewModel;

    public FragmentH()
    {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        fragmentHBinding = fragmentHBinding.inflate(
                inflater,
                container,
                false
        );
        return fragmentHBinding.getRoot();



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        thirdActivitySharedViewModel = ViewModelProviders.of(requireActivity()).get(thirdActivitySharedViewModel.class);


    }
}