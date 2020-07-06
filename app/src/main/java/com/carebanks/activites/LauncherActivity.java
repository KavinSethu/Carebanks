package com.carebanks.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.carebanks.R;
import com.carebanks.databinding.ActivityLauncherBinding;

public class LauncherActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityLauncherBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_launcher);
        initalize();
    }

    private void initalize() {
        binding.btnLogin.setOnClickListener(this);
        binding.btnSignup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                startActivity(new Intent(this,LoginActivity.class));
                break;
            case R.id.btn_signup:
                startActivity(new Intent(this,SignupActivity.class));
                break;
        }
    }
}