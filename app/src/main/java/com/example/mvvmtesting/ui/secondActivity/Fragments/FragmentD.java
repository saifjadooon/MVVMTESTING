package com.example.mvvmtesting.ui.secondActivity.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvvmtesting.R;
import com.example.mvvmtesting.databinding.FragmentDBinding;
import com.example.mvvmtesting.ui.secondActivity.SecondSharedViewModel;

public class FragmentD extends Fragment {

    private SecondSharedViewModel hSecondSharedViewModel;

    FragmentDBinding fragmentDBinding;

    public FragmentD() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentDBinding =fragmentDBinding.inflate(
                inflater,
                container,
                false
        );

        return fragmentDBinding.getRoot();
        // Inflate the layout for this fragment

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        hSecondSharedViewModel = ViewModelProviders.of(requireActivity()).get(SecondSharedViewModel.class);
    }
}