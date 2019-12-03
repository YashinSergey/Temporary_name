package com.example.temporaryname;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private Button btnExit;
    private TextInputEditText etLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        iniViews();

        btnLogin.setOnClickListener(clickListener);
        btnExit.setOnClickListener(clickListener);
    }

    private void iniViews() {
        btnLogin = findViewById(R.id.btnLogin);
        btnExit = findViewById(R.id.btnExit);
        etLogin = findViewById(R.id.etLogin);
    }


    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnLogin:
                    if (Objects.requireNonNull(etLogin.getText()).toString().equals("")) {
                        Snackbar.make(v, "Enter login!", Snackbar.LENGTH_SHORT).show();
                        hideKeyboard(v);
                    } else {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                    break;
                case R.id.btnExit:
                    finish();
            }

        }
    };

    private void hideKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager)this.getSystemService(Activity.INPUT_METHOD_SERVICE);
        Objects.requireNonNull(imm).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
