package com.example.rxjavademo.net.response;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.orhanobut.logger.Logger;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * 作者:wangyu
 * 创建时间:2019/11/18 17:55
 * 描述:
 */
final class NetResponseBodyConverter <T> implements Converter<ResponseBody, T> {

    private final Gson gson;
    private final TypeAdapter<T> adapter;
    private static final String SUCCESS_CODE = "OK";
    private Type type;

    NetResponseBodyConverter(Gson gson, TypeAdapter<T> adapter, Type type) {
        this.gson = gson;
        this.adapter = adapter;
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        MediaType MEDIA_TYPE = MediaType.parse("text/html; charset=UTF-8");
        if (value.contentType().equals(MEDIA_TYPE)) {
            throw new NetException();
        }
        try {
            return handleNetResult(value.string());
        }/*catch (Exception e){
            throw e;
        }*/ finally {
            value.close();
        }
    }

    private T handleNetResult(String result) throws IOException {
        Logger.d(result);
        NetResult netResult;
        try {
            netResult = gson.fromJson(result, NetResult.class);
        } catch (JsonSyntaxException e) {
            if (e.getMessage().contains("Expected BEGIN_OBJECT but was STRING")) {
                // 返回的数据本来就是字符串，直接返回
                return (T) result;
            } else {
                throw e;
            }
        }
        try {
            if (StringUtil.isEqual(SUCCESS_CODE, netResult.status)) {
                if (TextUtils.equals(type.toString(), ResultVoidBean.class.toString())) {
                    //如果是空的内容
                    return (T) new ResultVoidBean();
                }
                if (netResult.content == null) {
                    //如果为空
                    //因为 type.getTypeName()需要在28以上版本
                    String classPath = type.toString().replace("class", "").replace(" ", "");
                    if (TextUtils.equals("java.util.List<java.lang.String>", classPath)) {
                        return (T) new ArrayList<String>();
                    }
                    if (classPath.startsWith("java.util.List")) {
                        List list = new ArrayList<>();
                        return (T) list;
                    } else {
                        Class mClass = Class.forName(classPath);
                        return (T) mClass.getConstructor().newInstance();
                        //return null;
                    }
                }
                return adapter.read(gson.newJsonReader(new InputStreamReader(new ByteArrayInputStream(gson.toJson(netResult.content).getBytes()))));
            } else {
                throw new ApiException(netResult.errorCode, netResult.errorMsg);
            }
        } catch (Exception e) {
            if (e instanceof ApiException) {
                throw new ApiException(netResult.errorCode, netResult.errorMsg);
            } else {
                throw new ApiException(NetErrorCode.DATA_PARSE_ERROR, "数据解析出错" + e.getMessage());
            }
        }
    }

    public static class NetResult {
        public String errorCode;//错误状态码
        public String errorMsg;//错误提示信息
        public Object content;//数据内容
        public String status;//状态
    }
}
