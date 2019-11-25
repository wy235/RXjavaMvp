package com.example.rxjavademo.main.view;

import com.example.rxjavademo.base.BaseView;
import com.example.rxjavademo.main.bean.LivestockBean;

/**
 * 作者:wangyu
 * 创建时间:2019/11/18 10:22
 * 描述:
 */
public interface MainView extends BaseView {

    void getData(LivestockBean livestockBean);

    void setEmpteView();
}
