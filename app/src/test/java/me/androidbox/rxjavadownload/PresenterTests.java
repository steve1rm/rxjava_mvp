package me.androidbox.rxjavadownload;

import org.junit.Before;

import me.androidbox.rxjavadownload.downloader.DownloadModel;
import me.androidbox.rxjavadownload.downloader.DownloadModelContract;
import me.androidbox.rxjavadownload.downloader.DownloadPresenterContract;
import me.androidbox.rxjavadownload.downloader.DownloadPresenterImp;
import me.androidbox.rxjavadownload.downloader.DownloadViewContract;

import static org.mockito.Mockito.mock;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class PresenterTests implements DownloadPresenterContract.Events {
    private DownloadModelContract mockDownloadModelContract;
    private DownloadViewContract mockDownloadViewContract;
    private DownloadPresenterImp downloadPresenterImp;

    @Before
    public void setup() {
        mockDownloadModelContract = mock(DownloadModelContract.class);
        mockDownloadViewContract = mock(DownloadViewContract.class);
        downloadPresenterImp = DownloadPresenterImp.getNewInstance();

        downloadPresenterImp.attachView(mockDownloadViewContract);
        downloadPresenterImp.getData();

    }

    @Override
    public void onDownloadSuccess() {
        mockDownloadViewContract.onSuccessDownload();
    }

    @Override
    public void onDownloadFailed() {
        mockDownloadViewContract.onFailureDownload("Failed");
    }
}