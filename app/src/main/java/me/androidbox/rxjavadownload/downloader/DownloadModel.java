package me.androidbox.rxjavadownload.downloader;

import android.support.annotation.Nullable;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func0;
import rx.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by steve on 6/26/16.
 */
public class DownloadModel implements DownloadModelContract {
    private Subscription mSubscription;

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
        getGistObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Gist>() {
                    @Override
                    public void onCompleted() {
                        mPresenterEventsContract.onDownloadSuccess();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Timber.e(e.getMessage());
                        mPresenterEventsContract.onDownloadFailed();
                    }

                    @Override
                    public void onNext(Gist gist) {

                    }
                });
    }

    public Observable<Gist> getGistObservable() {
        return Observable.defer(new Func0<Observable<Gist>>() {
            @Override
            public Observable<Gist> call() {
                try {
                    return Observable.just(getData());
                }
                catch(IOException e) {
                    Timber.e(e.getMessage());
                    return null;
                }
            }
        });
    }

    @Nullable
    private Gist getData() throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.github.com/gists/db72a05cc03ef523ee74")
                .build();

        Response response = okHttpClient.newCall(request).execute();
        if(response.isSuccessful()) {
            return new Gson().fromJson(response.body().charStream(), Gist.class);
        }

        return null;
    }
}
