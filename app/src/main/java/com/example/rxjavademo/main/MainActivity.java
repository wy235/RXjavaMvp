package com.example.rxjavademo.main;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

import com.example.rxjavademo.R;
import com.example.rxjavademo.base.BaseActivity;
import com.example.rxjavademo.main.bean.LivestockBean;
import com.example.rxjavademo.main.model.MainModel;
import com.example.rxjavademo.main.presenter.MainPresenter;
import com.example.rxjavademo.main.view.MainView;
import com.example.rxjavademo.net.utils.ApiParams;
import com.example.rxjavademo.touchEvent.TouchEventActivity;
import com.example.rxjavademo.touchEvent.scroview.ScroViewActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter, MainModel> implements MainView {

    @BindView(R.id.mText)
    TextView mText;
    @BindView(R.id.mTouchEvent)
    TextView mTouchEvent;
    @BindView(R.id.mScroviewEvent)
    TextView mScroviewEvent;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main2;
    }

    @Override
    public void initModel() {
        mModel = new MainModel();
    }

    @Override
    public void initPresenter() {
        mPresenter = new MainPresenter(this, mModel, this);
    }

    @Override
    public void initView() {
        mText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiParams params = new ApiParams();
                params.put("cattleId", "547");
                mPresenter.getUserInfoService(params);
            }
        });

        mTouchEvent.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, TouchEventActivity.class);
            startActivity(intent);
        });

        mScroviewEvent.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ScroViewActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void getData(LivestockBean livestockBean) {
        if (livestockBean != null) {
            Log.e("LivestockBean",livestockBean.toString());
        }
    }

    @Override
    public void setEmpteView() {
        Toast.makeText(this,"设置空View",Toast.LENGTH_SHORT).show();
    }
}
