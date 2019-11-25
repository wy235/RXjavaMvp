package com.example.rxjavademo.net.utils;

import android.text.TextUtils;
import java.util.HashMap;

/**
 * 作者:wangyu
 * 创建时间:2019/11/18 11:53
 * 描述:
 */
public class ApiParams extends HashMap<String, Object> {

    public ApiParams() {
    }

    public ApiParams(String key, Object value) {
        put(key, value);
    }

    public ApiParams with(String key, Object value) {
        put(key, value);
        return this;
    }

    public ApiParams widthCheckNull(String key, Object value) {
        if (value instanceof String) {
            if (value != null) {
                String valueStr = value.toString();
                if (!TextUtils.isEmpty(valueStr) && !TextUtils.equals("null", valueStr)) {
                    put(key, value);
                }
            }
        }
        return this;
    }
}
