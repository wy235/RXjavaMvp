package com.example.rxjavademo.net.netsubscribe;

import com.example.rxjavademo.net.download.FileDownloadObserver;
import com.example.rxjavademo.net.netapi.FileApi;
import com.example.rxjavademo.net.netapi.URLConstant;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 下载文件相关
 */
public class DownloadSubscribe {

  /**
   * @param url 文件地址
   * @param destDir 存储文件夹
   * @param fileName 存储文件名
   * @param fileDownLoadObserver 监听回调
   */
  public static void downloadFile(@NonNull String url, final String destDir, final String fileName, final FileDownloadObserver<File> fileDownLoadObserver) {
    Retrofit retrofit = new Retrofit.Builder()
        .client(new OkHttpClient())
        .baseUrl(URLConstant.BASE_URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build();
    retrofit
        .create(FileApi.class)
        .downloadFileWithUrlSync(url)
        .subscribeOn(Schedulers.io())//subscribeOn和ObserOn必须在io线程，如果在主线程会出错
        .observeOn(Schedulers.io())
        .observeOn(Schedulers.computation())//需要
        .map(new Function<ResponseBody, File>() {
          @Override
          public File apply(@NonNull ResponseBody responseBody) throws Exception {
            return fileDownLoadObserver.saveFile(responseBody, destDir, fileName);
          }
        })
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(fileDownLoadObserver);
  }
}
