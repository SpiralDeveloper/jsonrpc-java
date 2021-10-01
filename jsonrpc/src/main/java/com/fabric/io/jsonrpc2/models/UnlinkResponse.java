package com.fabric.io.jsonrpc2.models;

import com.fabric.io.jsonrpc2.JsonRPCResponse;

public class UnlinkResponse {

    private final JsonRPCResponse response;

    public UnlinkResponse(JsonRPCResponse response){
        this.response = response;
    }

    public boolean to(){
        return (boolean) response.result;
    }
}
