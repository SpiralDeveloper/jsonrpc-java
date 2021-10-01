package com.fabric.io.jsonrpc2.models;

import com.fabric.io.jsonrpc2.JsonRPCResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class SearchResponse {

    private final JsonRPCResponse response;

    public SearchResponse(JsonRPCResponse response){
        this.response = response;
    }

    public <T> List<T> to(Class<T> tClass) {
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .create();
        final Type typeOf = new TypeToken<List<T>>() {
        }.getType();
        return gson.fromJson(response.result.toString(), typeOf);
    }
}
