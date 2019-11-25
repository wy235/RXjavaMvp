package com.example.rxjavademo.base;

import com.trello.rxlifecycle3.android.ActivityEvent;
import com.trello.rxlifecycle3.android.FragmentEvent;
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle3.components.support.RxFragment;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者:wangyu
 * 创建时间:2019/11/18 10:19
 * 描述:
 */
public abstract class BaseModel {

    /**
     * 请求失败重连次数
     */
    public int RETRY_COUNT = 1;
    public RxAppCompatActivity mRxActivity;
    public RxFragment mRxFragment;

    public Observable initActivityObservable(Observable observable){
        return observable.unsubscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.newThread())
                .retry(RETRY_COUNT)//请求失败重连次数
                .observeOn(AndroidSchedulers.mainThread())
                .compose(mRxActivity.bindUntilEvent(ActivityEvent.DESTROY));
    }

    public Observable initFragmentObservable(Observable observable){
        return observable.unsubscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.newThread())
                .retry(RETRY_COUNT)//请求失败重连次数
                .observeOn(AndroidSchedulers.mainThread())
                .compose(mRxFragment.bindUntilEvent(FragmentEvent.DESTROY));
    }
}
