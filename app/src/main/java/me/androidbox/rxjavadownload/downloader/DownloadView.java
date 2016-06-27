package me.androidbox.rxjavadownload.downloader;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.androidbox.rxjavadownload.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DownloadView extends Fragment implements DownloadViewContract {
    @BindView(R.id.tvDisplayResult) TextView mTvDisplayResult;

    private DownloadPresenterContract.Operations<DownloadViewContract> mDownloadPresenterContract;

    public DownloadView() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.download_view, container, false);

        ButterKnife.bind(DownloadView.this, view);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mDownloadPresenterContract = DownloadPresenterImp.getNewInstance();
        mDownloadPresenterContract.attachView(DownloadView.this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mDownloadPresenterContract.detachView();
    }

    @SuppressWarnings("unused")
    @OnClick(R.id.btnStartDownload)
    void btnStartDownload() {
        mDownloadPresenterContract.getData();
    }

    @Override
    public void onSuccessDownload() {
        Toast.makeText(getActivity(), "onSuccessDownload", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailureDownload(String errMsg) {
        Toast.makeText(getActivity(), "onFailureDownload", Toast.LENGTH_SHORT).show();
    }
}
