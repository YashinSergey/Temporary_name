package com.example.temporaryname.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.temporaryname.R;

public class InteriorFragment extends BaseFragment {

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_interior, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView.setImageDrawable(getResources().getDrawable(R.drawable.hi_tech_interior));
        textViewTitle.setText(R.string.hi_tech_style_in_interior);
        textViewContent.setText(getString(R.string.interior_text));
    }

}