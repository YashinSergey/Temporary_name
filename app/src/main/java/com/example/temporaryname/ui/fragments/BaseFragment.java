package com.example.temporaryname.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.temporaryname.R;

public class BaseFragment extends Fragment {

    protected ImageView imageView;
    protected TextView textViewTitle;
    protected TextView textViewContent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(@NonNull View view) {
        imageView = view.findViewById(R.id.imageViewFragments);
        textViewTitle = view.findViewById(R.id.textViewFragmentTitle);
        textViewContent = view.findViewById(R.id.textViewFragmentContent);
    }
}
