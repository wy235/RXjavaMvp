package com.example.rxjavademo.net.netapi;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by 眼神 on 2018/3/27.
 * <p>
 * 存放所有的Api
 */

public interface FileApi {

    @GET()
    @Streaming
    Observable<ResponseBody> downloadFileWithUrlSync(@Url String fileUrl);
}
