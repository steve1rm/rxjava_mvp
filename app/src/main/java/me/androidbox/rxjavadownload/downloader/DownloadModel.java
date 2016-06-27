package me.androidbox.rxjavadownload.downloader;

/**
 * Created by steve on 6/26/16.
 */
public class DownloadModel implements DownloadModelContract {

    private DownloadPresenterContract.Events mPresenterEventsContract;
    private DownloadModel(DownloadPresenterContract.Events downloadPresenterContract) {
        mPresenterEventsContract = downloadPresenterContract;
    }

    /* Factory Method */
    public static DownloadModel getNewInstance(DownloadPresenterContract.Events events) {
        return new DownloadModel(events);
    }

    @Override
    public void retrieveData() {
        mPresenterEventsContract.onDownloadFailed();
    }
}
