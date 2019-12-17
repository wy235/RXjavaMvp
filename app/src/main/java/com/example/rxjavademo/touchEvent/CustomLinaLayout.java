package com.example.rxjavademo.touchEvent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * 作者:wangyu
 * 创建时间:2019/12/17 14:05
 * 描述:
 */
public class CustomLinaLayout extends LinearLayout {

    public CustomLinaLayout(Context context) {
        super(context);
    }

    public CustomLinaLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //第二个执行 事件拦截
    // 返回false or 返回super  不拦截
    // 返回true拦截  事件不会往下面传递 调用自身onTouchEvent
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("CustomLinaLayout", "CustomLinaLayout..........onInterceptTouchEvent");
        return super.onInterceptTouchEvent(ev);
    }

    //dispatchTouchEvent 第一个执行
    //返回false事件不会往下传递调用Activity onTouchEvent
    //返回true事件不会往下传递，事件消费
    //返回super  事件往下传递
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("CustomLinaLayout", "CustomLinaLayout..........dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    //最后一个执行   事件消费
    //返回true  事件消费
    //返回 super false  调用Activity onTouchEvent
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("CustomLinaLayout", "CustomLinaLayout..........onTouchEvent");
        return super.onTouchEvent(event);
    }
}
