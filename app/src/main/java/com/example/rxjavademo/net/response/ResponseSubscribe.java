package com.example.rxjavademo.net.response;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 作者:wangyu
 * 创建时间:2019/11/18 9:55
 * 描述:
 */
public class ResponseSubscribe<T> implements Observer<T> {



    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }

    public void onNetError(Throwable e){

    }
}
