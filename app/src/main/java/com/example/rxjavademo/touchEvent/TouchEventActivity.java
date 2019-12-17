package com.example.rxjavademo.touchEvent;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.rxjavademo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TouchEventActivity extends AppCompatActivity {

    @BindView(R.id.mCustomLinaLayout)
    CustomLinaLayout mCustomLinaLayout;
    @BindView(R.id.mCustomView)
    CustomView mCustomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_event);
        ButterKnife.bind(this);
        mCustomView.setOnClickListener(view -> {
            Log.e("CustomTouchActivity","子View");
            Toast.makeText(this,"子View",Toast.LENGTH_SHORT).show();
        });

        mCustomLinaLayout.setOnClickListener(view -> {
            Log.e("CustomTouchActivity","子ViewGroup");
            Toast.makeText(this,"子ViewGroup",Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        Log.e("CustomTouchActivity", "TouchEventActivity..........dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("CustomTouchActivity", "TouchEventActivity..........onTouchEvent");
        return super.onTouchEvent(event);
    }
}
