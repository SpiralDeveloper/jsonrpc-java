package com.fabric.io.jsonrpc2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class JsonRPCRequest {

    private final String jsonrpc = "2.0";
    private final String method;
    private Long id;
    private final List<Object> params;


    public JsonRPCRequest(String method, Long id, List<Object> params) {
        this.id = id;
        this.method = method;
        this.params = params;
    }


    @NotNull
    @Override
    public String toString() {
        Gson gson = new GsonBuilder()
                .serializeNulls()
                .create();
        return gson.toJson(this);
    }
}
