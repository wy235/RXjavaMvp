package com.example.rxjavademo.main.model;

import com.example.rxjavademo.api.HttpApi_User;
import com.example.rxjavademo.base.BaseModel;
import com.example.rxjavademo.main.bean.LivestockBean;
import com.example.rxjavademo.net.netapi.UserApi;
import com.example.rxjavademo.net.netutils.RetrofitApi;
import com.example.rxjavademo.net.utils.ApiParams;
import io.reactivex.Observable;

/**
 * 作者:wangyu
 * 创建时间:2019/11/18 10:22
 * 描述:
 */
public class MainModel extends BaseModel {

    public Observable<LivestockBean> getUserInfoService(ApiParams params) {
        return initActivityObservable(RetrofitApi.getInstance().getProxy(UserApi.class)
                .getUserInfoService(HttpApi_User.API_GET_USER_INFO,params));
    }
}
