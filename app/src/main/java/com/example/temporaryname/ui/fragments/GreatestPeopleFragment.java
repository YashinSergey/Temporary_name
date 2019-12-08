package com.example.temporaryname.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.temporaryname.R;

public class GreatestPeopleFragment extends BaseFragment {

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_greatest_people, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.abraham_lincoln));
        textViewTitle.setText(R.string.abraham_lincoln_title);
        textViewContent.setText(getString(R.string.abraham_lincoln_biography));
    }
}