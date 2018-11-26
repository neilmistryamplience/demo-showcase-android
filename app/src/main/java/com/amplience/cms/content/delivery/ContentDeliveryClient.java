package com.amplience.cms.content.delivery;

import com.amplience.cms.content.delivery.model.QueryResult;
import com.google.gson.JsonObject;

import java.util.Date;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ContentDeliveryClient {

    private final String baseUrl;
    private final String account;
    private final ContentDeliveryService service;

    private ContentDeliveryClient(final Builder builder) {
        this(builder.getBaseUrl(), builder.getAccount());
    }

    private ContentDeliveryClient(final String baseUrl, final String account) {
        this.baseUrl = baseUrl;
        this.account = account;
        this.service = createService(baseUrl);
    }

    public Call<QueryResult> query(JsonObject query) {
        return service.query(query, account, "tree", true, new Date().getTime());
    }

    public Call<QueryResult> query(JsonObject query, String locale) {
        return service.query(query, account, "tree", true, locale, new Date().getTime());
    }

    public Call<QueryResult> getById(String id) {
        JsonObject query = new JsonObject();
        query.addProperty("sys.iri", "http://content.cms.amplience.com/" + id);
        return this.query(query);
    }

    public Call<QueryResult> getById(String id, String locale) {
        JsonObject query = new JsonObject();
        query.addProperty("sys.iri", "http://content.cms.amplience.com/" + id);
        return this.query(query, locale);
    }

    private ContentDeliveryService createService(final String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(ContentDeliveryService.class);
    }

    public static class Builder {

        private String baseUrl;
        private String account;

        public Builder setBaseUrl(final String baseUrl) {
            this.baseUrl = baseUrl;
            return this;
        }

        public Builder setAccount(final String account) {
            this.account = account;
            return this;
        }

        public String getBaseUrl() {
            return baseUrl;
        }

        public String getAccount() {
            return account;
        }

        public ContentDeliveryClient build() {
            return new ContentDeliveryClient(this);
        }
    }
}
