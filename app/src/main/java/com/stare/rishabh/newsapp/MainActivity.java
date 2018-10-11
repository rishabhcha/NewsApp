package com.stare.rishabh.newsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.stare.rishabh.newsapp.model.TopHeadline;
import com.stare.rishabh.newsapp.network.ApiClient;
import com.stare.rishabh.newsapp.network.ApiInterface;
import com.stare.rishabh.newsapp.util.Constants;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApi();
            }
        });

    }

    private void callApi() {

        ApiInterface apiInterface = ApiClient.getClient(getApplicationContext()).create(ApiInterface.class);

        apiInterface.getTopHeadlines("in", Constants.NEWS_API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<TopHeadline>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(TopHeadline topHeadline) {

                        Log.d("---------------", String.valueOf(topHeadline.getTotalResults()));

                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.d("---------------error", e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                        Log.d("---------------", "completed");

                    }
                });

    }
}
