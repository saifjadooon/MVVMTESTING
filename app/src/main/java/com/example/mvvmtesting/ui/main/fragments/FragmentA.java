package com.example.mvvmtesting.ui.main.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.mvvmtesting.R;
import com.example.mvvmtesting.databinding.FragmentABinding;

public class FragmentA extends Fragment {

    private FragmentABinding hFragmentABinding;

    public FragmentA() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        hFragmentABinding = FragmentABinding.inflate(
                inflater,
                container,
                false
        );

        return hFragmentABinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        hFragmentABinding.hFRA.setOnClickListener(view1 -> {
            Navigation.findNavController(view1).navigate(R.id.action_fragmentA_to_fragmentB2);
        });
    }
}