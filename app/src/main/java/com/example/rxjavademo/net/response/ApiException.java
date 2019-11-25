package com.example.rxjavademo.net.response;

/**
 * 作者:wangyu
 * 创建时间:2019/11/18 17:56
 * 描述:
 */
public class ApiException extends RuntimeException {
    private String code;
    private String message;

    public ApiException(String code, String msg) {
        super(msg);
        this.code = code;
        this.message = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
