package com.example.rxjavademo.net.netapi;

import com.example.rxjavademo.main.bean.LivestockBean;
import com.example.rxjavademo.net.utils.ApiParams;
import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * 作者:wangyu
 * 创建时间:2019/11/18 10:39
 * 描述:
 */
public interface UserApi{
    @FormUrlEncoded
    @POST
    Observable<LivestockBean> getUserInfoService(@Url String url, @FieldMap ApiParams params);
}
