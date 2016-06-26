package me.androidbox.rxjavadownload.downloader;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by steve on 6/26/16.
 */
public class ApplicationModule extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());
        Timber.d("ApplicationModule");
    }
}
