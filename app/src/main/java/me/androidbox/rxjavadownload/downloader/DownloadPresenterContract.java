package me.androidbox.rxjavadownload.downloader;

/**
 * Created by steve on 6/25/16.
 */
public interface DownloadPresenterContract {
    interface Operations<DownloadViewContract> {
        void attachView(DownloadViewContract view);
        void detachView();
        void getData();
    }

    interface Events {
        void onDownloadSuccess();
        void onDownloadFailed();
    }
}
