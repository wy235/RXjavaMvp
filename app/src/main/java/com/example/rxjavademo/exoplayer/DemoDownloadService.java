package com.example.rxjavademo.exoplayer;

import android.annotation.SuppressLint;
import android.app.Notification;

import com.example.rxjavademo.BaseAplication;
import com.example.rxjavademo.R;
import com.google.android.exoplayer2.offline.Download;
import com.google.android.exoplayer2.offline.DownloadManager;
import com.google.android.exoplayer2.offline.DownloadService;
import com.google.android.exoplayer2.scheduler.PlatformScheduler;
import com.google.android.exoplayer2.ui.DownloadNotificationHelper;
import com.google.android.exoplayer2.util.NotificationUtil;
import com.google.android.exoplayer2.util.Util;

import java.util.List;

/**
 * 作者:wangyu
 * 创建时间:2019/12/11 11:52
 * 描述:
 */
public class DemoDownloadService extends DownloadService {

    private static final String CHANNEL_ID = "download_channel";
    private static final int JOB_ID = 1;
    private static final int FOREGROUND_NOTIFICATION_ID = 1;

    private static int nextNotificationId = FOREGROUND_NOTIFICATION_ID + 1;

    private DownloadNotificationHelper notificationHelper;

    public DemoDownloadService() {
        super(
                FOREGROUND_NOTIFICATION_ID,
                DEFAULT_FOREGROUND_NOTIFICATION_UPDATE_INTERVAL,
                CHANNEL_ID,
                R.string.exo_download_notification_channel_name,
                /* channelDescriptionResourceId= */ 0);
        nextNotificationId = FOREGROUND_NOTIFICATION_ID + 1;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        notificationHelper = new DownloadNotificationHelper(this, CHANNEL_ID);
    }

    @Override
    protected DownloadManager getDownloadManager() {
        return ((BaseAplication) getApplication()).getDownloadManager();
    }

    @SuppressLint("MissingPermission")
    @Override
    protected PlatformScheduler getScheduler() {
        return Util.SDK_INT >= 21 ? new PlatformScheduler(this, JOB_ID) : null;
    }

    @Override
    protected Notification getForegroundNotification(List<Download> downloads) {
        return notificationHelper.buildProgressNotification(
                R.drawable.ic_download, /* contentIntent= */ null, /* message= */ null, downloads);
    }

    @Override
    protected void onDownloadChanged(Download download) {
        Notification notification;
        if (download.state == Download.STATE_COMPLETED) {
            notification =
                    notificationHelper.buildDownloadCompletedNotification(
                            R.drawable.ic_download_done,
                            /* contentIntent= */ null,
                            Util.fromUtf8Bytes(download.request.data));
        } else if (download.state == Download.STATE_FAILED) {
            notification =
                    notificationHelper.buildDownloadFailedNotification(
                            R.drawable.ic_download_done,
                            /* contentIntent= */ null,
                            Util.fromUtf8Bytes(download.request.data));
        } else {
            return;
        }
        NotificationUtil.setNotification(this, nextNotificationId++, notification);
    }
}
