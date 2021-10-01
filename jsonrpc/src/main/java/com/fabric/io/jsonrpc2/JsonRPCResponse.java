package com.fabric.io.jsonrpc2;

import android.util.Log;

import com.fabric.io.jsonrpc2.exceptions.JsonRPCError;

import java.util.Map;

public class JsonRPCResponse {
    public Object result;
    public String jsonrpc;
    public Long id;
    public Map<String, Object> error;

    public void isOk() throws JsonRPCError {
        if (error != null) {
            throw new JsonRPCError(error.get("code"), (String) error.get("message"));
        }
    }
}
