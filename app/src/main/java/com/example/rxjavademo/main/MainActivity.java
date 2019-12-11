package com.example.rxjavademo.main;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.example.rxjavademo.R;
import com.example.rxjavademo.base.BaseActivity;
import com.example.rxjavademo.exoplayer.SampleChooserActivity;
import com.example.rxjavademo.main.bean.LivestockBean;
import com.example.rxjavademo.main.model.MainModel;
import com.example.rxjavademo.main.presenter.MainPresenter;
import com.example.rxjavademo.main.view.MainView;
import com.example.rxjavademo.net.utils.ApiParams;
import butterknife.BindView;

public class MainActivity extends BaseActivity<MainPresenter, MainModel> implements MainView {

    @BindView(R.id.mText)
    TextView mText;

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
                Intent intent = new Intent(MainActivity.this, SampleChooserActivity.class);
                startActivity(intent);
              /*  ApiParams params = new ApiParams();
                params.put("cattleId", "547");
                mPresenter.getUserInfoService(params);*/
            }
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
