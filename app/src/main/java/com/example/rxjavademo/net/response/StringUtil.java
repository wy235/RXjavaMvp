package com.example.rxjavademo.net.response;

import android.text.TextUtils;
import android.widget.EditText;

/**
 * 作者:wangyu
 * 创建时间:2019/11/18 17:57
 * 描述:
 */
public class StringUtil {

    private StringUtil() {
    }

    /**
     * 字符串是否为空
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(CharSequence str) {
        return TextUtils.isEmpty(str.toString().trim());
    }

    /**
     * 字符串是否不为空
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(CharSequence str) {
        return !TextUtils.isEmpty(str);
    }

    /**
     * EditText 是否为空
     *
     * @param editText
     * @return
     */
    public static boolean isEmpty(EditText editText) {
        return isEmpty(editText.getText().toString().trim());
    }

    /**
     * 比较两个字符串是否相等
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean isEqual(CharSequence a, CharSequence b) {
        return TextUtils.equals(a, b);
    }

    /**
     * 比较两个字符串是否不相等
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean isNotEqual(CharSequence a, CharSequence b) {
        return !TextUtils.equals(a, b);
    }

    public static boolean isNumeric(String str){
        for (int i = str.length();--i>=0;){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
