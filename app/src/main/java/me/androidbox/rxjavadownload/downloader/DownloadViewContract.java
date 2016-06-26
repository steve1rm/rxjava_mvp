package me.androidbox.rxjavadownload.downloader;

/**
 * Created by steve on 6/24/16.
 */
public interface DownloadViewContract {
    void onSuccessDownload();
    void onFailureDownload(String errMsg);
}
