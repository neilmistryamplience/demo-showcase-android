package com.amplience.cms.content.delivery;

import com.amplience.cms.content.delivery.model.QueryResult;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by darren on 09/11/2017.
 */

public interface ContentDeliveryService {

    @GET("/cms/content/query")
    Call<QueryResult> query(
        @Query(value = "query", encoded = true) JsonObject query,
        @Query("store") String store,
        @Query("scope") String scope,
        @Query("fullBodyObject") boolean fullBodyObject,
        @Query("timestamp") long timestamp
    );

    @GET("/cms/content/query")
    Call<QueryResult> query(
        @Query(value = "query", encoded = true) JsonObject query,
        @Query("store") String store,
        @Query("scope") String scope,
        @Query("fullBodyObject") boolean fullBodyObject,
        @Query("locale") String locale,
        @Query("timestamp") long timestamp
    );

}
