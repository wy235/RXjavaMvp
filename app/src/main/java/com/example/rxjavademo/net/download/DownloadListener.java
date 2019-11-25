package com.example.rxjavademo.net.download;

public interface DownloadListener {
  void onStartDownload(long length);
  void onProgress(int progress);
  void onFail(String errorInfo);
}
