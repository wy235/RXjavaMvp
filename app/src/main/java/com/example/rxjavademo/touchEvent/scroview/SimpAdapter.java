package com.example.rxjavademo.touchEvent.scroview;

import androidx.annotation.NonNull;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.rxjavademo.R;

/**
 * 作者:wangyu
 * 创建时间:2019/12/17 16:35
 * 描述:
 */
public class SimpAdapter extends BaseQuickAdapter<Object, BaseViewHolder> {

    public SimpAdapter() {
        super(R.layout.item_simp);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, Object item) {

    }
}
