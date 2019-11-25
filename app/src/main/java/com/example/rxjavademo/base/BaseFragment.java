package com.example.rxjavademo.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.trello.rxlifecycle3.components.support.RxFragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 作者:wangyu
 * 创建时间:2019/11/25 14:01
 * 描述:
 */
public abstract class BaseFragment<P extends BasePresenter, M extends BaseModel> extends RxFragment {

    public P mPresenter;
    public M mModel;
    public View rootView;
    private Unbinder mUnbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(getLayoutId(), container, false);
        }
        mUnbinder = ButterKnife.bind(this, rootView);
        initModel();
        if(mModel != null){
            mModel.mRxFragment = this;
        }
        initView();
        initPresenter();
        return rootView;
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
    public void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
