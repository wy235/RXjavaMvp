package com.example.rxjavademo.base;

import android.os.Bundle;
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity;
import butterknife.ButterKnife;

/**
 * 作者:wangyu
 * 创建时间:2019/11/18 13:59
 * 描述:
 */
public abstract class BaseActivity<P extends BasePresenter, M extends BaseModel> extends RxAppCompatActivity {

    public P mPresenter;
    public M mModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initModel();
        if (mModel != null) {
            mModel.mRxActivity = this;
        }
        initView();
        initPresenter();
    }

    /**
     * 获取布局文件
     */
    public abstract int getLayoutId();

    /**
     * 初始化Model
     */
    public abstract void initModel();

    /**
     * 初始化Presenter
     */
    public abstract void initPresenter();

    /**
     * 初始化View
     */
    public abstract void initView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
