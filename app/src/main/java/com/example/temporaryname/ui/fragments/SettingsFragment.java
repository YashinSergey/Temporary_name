package com.example.temporaryname.ui.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.temporaryname.R;
import com.example.temporaryname.ui.MainActivity;

import java.util.Objects;

public class SettingsFragment extends Fragment implements View.OnClickListener {

    private CheckBox cbDefault;
    private CheckBox cbOrange;
    private CheckBox cbBlue;
    private CheckBox cbBrown;
    private Activity activity;
    private SharedPreferences sPref;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        activity = (MainActivity)getActivity();
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews(view);

        setOnClickListeners();

    }

    private void setOnClickListeners() {
        cbDefault.setOnClickListener(this);
        cbOrange.setOnClickListener(this);
        cbBlue.setOnClickListener(this);
        cbBrown.setOnClickListener(this);
    }

    private void initViews(@NonNull View view) {
        cbDefault = view.findViewById(R.id.cb_default);
        cbOrange = view.findViewById(R.id.cb_orange);
        cbBlue = view.findViewById(R.id.cb_blue);
        cbBrown = view.findViewById(R.id.cb_brown);
    }

    @Override
    public void onClick(View v) {
        sPref = Objects.requireNonNull(getActivity()).getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        int themeNum = -1;
        int id = v.getId();
        switch (id) {
            case R.id.cb_default:
                themeNum = R.style.DefaultAppTheme_NoActionBar;
                break;
            case R.id.cb_orange:
                themeNum = R.style.OrangeTheme_NoActionBar;
                break;
            case R.id.cb_blue:
                themeNum = R.style.BlueTheme_NoActionBar;
                break;
            case R.id.cb_brown:
            case -1:
                themeNum = R.style.BrownTheme_NoActionBar;
                break;
        }
        editor.putInt(MainActivity.THEME, themeNum);
        editor.apply();
        activity.recreate();
    }
}
