package me.androidbox.rxjavadownload.downloader;

import timber.log.Timber;

/**
 * Created by steve on 6/25/16.
 */
public class DownloadPresenterImp implements
        DownloadPresenterContract.Operations<DownloadViewContract>,
        DownloadPresenterContract.Events {

    private DownloadViewContract mView;
    private DownloadModelContract mDownloadModelContract;

    private DownloadPresenterImp() {
        Timber.d("DownloadPresenterImp");
        mDownloadModelContract = DownloadModel.getNewInstance();
    }

    public static DownloadPresenterImp getNewInstance() {
        return new DownloadPresenterImp();
    }

    /* Operations */
    @Override
    public void attachView(DownloadViewContract view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public void getData() {
        mDownloadModelContract.retrieveData();
    }

    /* Events */
    @Override
    public void onDownloadSuccess() {
        mView.onSuccessDownload();
    }

    @Override
    public void onDownloadFailed() {
        mView.onFailureDownload("Failed");
    }

}
