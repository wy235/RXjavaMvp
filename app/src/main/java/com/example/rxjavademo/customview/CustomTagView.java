package com.example.rxjavademo.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * 作者:wangyu
 * 创建时间:2019/12/26 17:21
 * 描述:
 */
public class CustomTagView extends ViewGroup {

    private BaseAdapter adapter;

    public CustomTagView(Context context) {
        super(context);
    }

    public CustomTagView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomTagView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomTagView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        // 计算出所有的childView的宽和高
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        //测量并保存layout的宽高(使用getDefaultSize时，wrap_content和match_perent都是填充屏幕)
        //稍后会重新写这个方法，能达到wrap_content的效果
        setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec),
                getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec));

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int count = getChildCount();
        int childMeasureWidth = 0;
        int childMeasureHeight = 0;
        int layoutWidth = 0;    // 容器已经占据的宽度
        int layoutHeight = 0;   // 容器已经占据的宽度

        View view = null;
        for (int i = 0; i < count; i++) {
            view = getChildAt(i);
            childMeasureWidth = view.getMeasuredWidth();
            childMeasureHeight = view.getMeasuredHeight();
            int lineWhdth = getWidth() - layoutWidth;
            if(lineWhdth > 0 && lineWhdth > childMeasureWidth) {
                left = layoutWidth;
                right = lineWhdth + childMeasureWidth;
                top = layoutHeight;
                bottom = layoutHeight + childMeasureHeight;
            }else{
                layoutWidth = 0;
                layoutHeight += childMeasureHeight;
                left = layoutWidth;
                right = left+childMeasureWidth;
                top = layoutHeight;
                bottom = top+childMeasureHeight;

            }
            layoutWidth += childMeasureWidth;  //宽度累加
            view.layout(left,top,right,bottom);
        }
    }
}
