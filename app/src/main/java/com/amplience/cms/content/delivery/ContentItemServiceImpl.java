package com.amplience.cms.content.delivery;

import com.amplience.cms.content.delivery.model.ContentItem;
import com.amplience.cms.content.delivery.model.QueryResult;
import com.amplience.cms.content.delivery.serialization.ContentItemDeserializer;
import com.google.common.base.Optional;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContentItemServiceImpl implements ContentItemService {

    private static final int MAX_RETRIES = 10;

    private final ContentDeliveryClient apiClient;
    private final ContentItemDeserializer deserializer;
    private final String locale;

    public ContentItemServiceImpl(final ContentDeliveryClient apiClient, ContentItemDeserializer deserializer, String locale) {
        this.apiClient = apiClient;
        this.deserializer = deserializer;
        this.locale = locale;
    }


    public void getById(String id, final OnContentItemLoaded callback) {

        Call<QueryResult> call = apiClient.getById(id, locale);
        call.enqueue(new Callback<QueryResult>() {

            private int retries = 0;

            @Override
            public void onResponse(Call<QueryResult> call, Response<QueryResult> response) {

                boolean ok = response.isSuccessful();
                QueryResult result = response.body();

                if(result == null || result.getResults() == null) {
                    ok = false;
                }

                if(ok){
                    if(result.getResults().size() == 0) {
                        callback.onLoaded(new Error("No matching results found"), null);
                        return;
                    }

                    String rootId = result.getResults().get(0).getId();
                    Optional<JsonObject> tree = result.getGraph().getContentTree(rootId);

                    Gson gson = new GsonBuilder()
                            .registerTypeAdapter(ContentItem.class, deserializer)
                            .create();

                    try {
                        ContentItem contentItem = gson.fromJson(tree.get(), ContentItem.class);
                        callback.onLoaded(null, contentItem);
                    }catch(Exception ex){
                        ex.printStackTrace();
                    }finally{
                        gson = null;
                        response = null;
                    }
                }else{
                    retry(call);
                }
            }

            @Override
            public void onFailure(Call<QueryResult> call, Throwable t) {
                retry(call);
            }

            private void retry(Call<QueryResult> call) {
                if(retries < MAX_RETRIES) {
                    call.clone().enqueue(this);
                }else{
                    callback.onLoaded(new Error("Maximum retries exceeded"), null);
                }
                retries++;
            }
        });

    }

}
