package com.example.rxjavademo.base;

import android.content.Context;

/**
 * 作者:wangyu
 * 创建时间:2019/11/18 10:20
 * 描述:
 */
public abstract class BasePresenter<V, M> {

    public Context mContext;
    public M mModel;
    public V mView;

    public BasePresenter(Context mContext, M mModel, V mView) {
        this.mContext = mContext;
        setVM(mView, mModel);
    }

    public void setVM(V view, M model) {
        this.mView = view;
        this.mModel = model;
    }
}
