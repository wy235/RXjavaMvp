package com.example.rxjavademo.touchEvent;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * 作者:wangyu
 * 创建时间:2019/12/17 14:15
 * 描述:
 */
@SuppressLint("AppCompatCustomView")
public class CustomView extends TextView {

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //子View
    //返回false 调用上级onTouchEvent处理事件  否则调用Activity onTouchEvent
    //返回true  事件消费
    //返回super 事件继续传递 直到消费  否则Activity处理
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("CustomView", "CustomView..........dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }

    //返回true 事件消费
    //返回super  false调用上级onTouchEvent
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("CustomView", "CustomView..........onTouchEvent");
        return super.onTouchEvent(event);
    }
}
