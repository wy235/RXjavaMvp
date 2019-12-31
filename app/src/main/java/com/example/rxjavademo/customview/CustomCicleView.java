package com.example.rxjavademo.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * 作者:wangyu
 * 创建时间:2019/12/17 20:37
 * 描述:
 */
public class CustomCicleView extends View {
    private final static String TAG = "CustomCicleView";

    private Paint mPaint = new Paint();
    private int mDefaultX = 200;
    private int mDefaultY = 200;

    public CustomCicleView(Context context) {
        super(context);
    }

    public CustomCicleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setColor(Color.RED);
        canvas.drawCircle(mDefaultX,mDefaultY,200,mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        final int minWidth = getSuggestedMinimumWidth();
        final int minHeight = getSuggestedMinimumHeight();
        int width = measureWidth(minWidth,widthMeasureSpec);
        int height = measureHeight(minHeight,heightMeasureSpec);
        setMeasuredDimension(width, height);
    }

    private int measureWidth(int defaultWidth, int measureSpec) {
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        Log.e(TAG + "Width", "---speSize = " + specSize + "");
        switch (specMode) {
            case MeasureSpec.AT_MOST:
                defaultWidth = mDefaultX + getPaddingLeft() + getPaddingRight();
                Log.e(TAG + "Width", "---speMode = AT_MOST");
                break;
            case MeasureSpec.EXACTLY:
                Log.e(TAG + "Width", "---speMode = EXACTLY");
                defaultWidth = specSize;
                break;
            case MeasureSpec.UNSPECIFIED:
                Log.e(TAG + "Width", "---speMode = UNSPECIFIED");
                defaultWidth = Math.max(defaultWidth, specSize);
        }
        return defaultWidth;
    }


    private int measureHeight(int defaultHeight, int measureSpec) {
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        Log.e("Height", "---speSize = " + specSize + "");
        switch (specMode) {
            case MeasureSpec.AT_MOST:
                defaultHeight = mDefaultY + getPaddingTop() + getPaddingBottom();
                Log.e("Height", "---speMode = AT_MOST");
                break;
            case MeasureSpec.EXACTLY:
                defaultHeight = specSize;
                Log.e("Height", "---speSize = EXACTLY");
                break;
            case MeasureSpec.UNSPECIFIED:
                defaultHeight = Math.max(defaultHeight, specSize);
                Log.e("Height", "---speSize = UNSPECIFIED");
                break;
        }
        return defaultHeight;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }
}
