package com.fabric.io.jsonrpc2.models;

import com.fabric.io.jsonrpc2.JsonRPCResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ReadResponse {

    private final JsonRPCResponse response;

    public ReadResponse(JsonRPCResponse response){
        this.response = response;
    }

    public <T> T to(Class<T> tClass) {
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .create();
        return gson.fromJson(response.result.toString(), tClass);
    }
}
