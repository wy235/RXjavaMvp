package com.example.rxjavademo.main.presenter;

import android.content.Context;
import com.example.rxjavademo.base.BasePresenter;
import com.example.rxjavademo.main.bean.LivestockBean;
import com.example.rxjavademo.main.view.MainView;
import com.example.rxjavademo.main.model.MainModel;
import com.example.rxjavademo.net.response.ResponseSubscribe;
import com.example.rxjavademo.net.utils.ApiParams;

/**
 * 作者:wangyu
 * 创建时间:2019/11/18 10:22
 * 描述:
 */
public class MainPresenter extends BasePresenter<MainView, MainModel> {

    public MainPresenter(Context mContext, MainModel mModel, MainView mView) {
        super(mContext, mModel, mView);
    }

    public void getUserInfoService(ApiParams params) {
        mModel.getUserInfoService(params).subscribe(new ResponseSubscribe<LivestockBean>(){
            @Override
            public void onNext(LivestockBean livestockBean) {
                mView.getData(livestockBean);
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
            }
        });
    }
}
