package com.fabric.io.jsonrpc2;

import com.fabric.io.jsonrpc2.exceptions.JsonResponseException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class JsonRPCClient {

    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private final OkHttpClient.Builder client;
    private final String url;

    public JsonRPCClient(String url, Map<String, String> headers) {
        this.url = url;
        this.client = new OkHttpClient.Builder();
        this.client.addInterceptor(chain -> {
            Request.Builder request = chain.request().newBuilder();
            if (headers != null) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    request.addHeader(key, value);
                }
            }
            return chain.proceed(request.build());
        });
    }

    public JsonRPCResponse request(@NotNull JsonRPCRequest rpcRequest) throws IOException, JsonResponseException {
        RequestBody body = RequestBody.create(rpcRequest.toString(), JSON);
        Request request = new Request.Builder()
                .url(this.url)
                .post(body)
                .build();
        Response response = client.build().newCall(request).execute();
        if (response.isSuccessful()) {
            String responseString = Objects.requireNonNull(response.body()).string();
            Gson gson = new GsonBuilder()
                    .serializeNulls()
                    .create();
            return gson.fromJson(responseString, JsonRPCResponse.class);
        }
        throw new JsonResponseException(response.code());
    }

}
