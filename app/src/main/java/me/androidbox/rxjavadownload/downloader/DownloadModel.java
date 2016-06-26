package me.androidbox.rxjavadownload.downloader;

/**
 * Created by steve on 6/26/16.
 */
public class DownloadModel implements DownloadModelContract {

    private DownloadModel() {
    }

    /* Factory Method */
    public static DownloadModel getNewInstance() {
        return new DownloadModel();
    }

    @Override
    public void retrieveData() {

    }
}
