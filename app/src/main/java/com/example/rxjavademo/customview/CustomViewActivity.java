package com.example.rxjavademo.customview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.rxjavademo.R;

import butterknife.ButterKnife;

public class CustomViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        ButterKnife.bind(this);
    }
}
