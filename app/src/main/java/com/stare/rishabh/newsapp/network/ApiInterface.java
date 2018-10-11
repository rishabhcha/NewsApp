package com.stare.rishabh.newsapp.network;

import com.stare.rishabh.newsapp.model.TopHeadline;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/*
 ** Uses the URL Endpoint and other queries to complete the call.
 **/
public interface ApiInterface {

    //to fetch top headlines of a particular country
    @GET("top-headlines")
    Observable<TopHeadline> getTopHeadlines(
            @Query("country") String country,
            @Query("apiKey") String apiKey
    );

}
