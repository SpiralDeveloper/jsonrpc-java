package com.fabric.io.jsonrpc2.models;


import com.fabric.io.jsonrpc2.JsonRPCClient;
import com.fabric.io.jsonrpc2.JsonRPCRequest;
import com.fabric.io.jsonrpc2.JsonRPCResponse;
import com.fabric.io.jsonrpc2.exceptions.JsonRPCError;
import com.fabric.io.jsonrpc2.exceptions.JsonResponseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModelRequest {

    private final JsonRPCClient client;
    private final String model;

    public ModelRequest(JsonRPCClient client, String model) {
        this.client = client;
        this.model = model;
    }

    public CreateResponse create(Map<String, Object> values, List<String> browseFields) throws IOException, JsonResponseException, JsonRPCError {
        Map<String, Object> context = new HashMap<>();
        context.put("fields", browseFields);
        List<Object> params = Arrays.asList(model, "create", values, context);
        JsonRPCResponse response = call( null, params);
        response.isOk();
        return new CreateResponse(response);
    }

    public WriteResponse write(long id, Map<String, Object> values) throws IOException, JsonResponseException, JsonRPCError {
        List<Object> params = Arrays.asList(model, "write", id, values);
        JsonRPCResponse response = call(null, params);
        return new WriteResponse(response);
    }

    public ReadResponse read(long id, List<String> browseFields) throws JsonResponseException, JsonRPCError, IOException {
        HashMap<String, Object> context = new HashMap<>();
        context.put("fields", browseFields);
        List<Object> params = Arrays.asList(model, "read", id, context);
        JsonRPCResponse response = call(null, params);
        return new ReadResponse(response);
    }

    public SearchResponse search(int limit, List<String> browseFields) throws JsonResponseException, JsonRPCError, IOException {
        List<Object> filter = new ArrayList<>();
        HashMap<String, Object> context = new HashMap<>();
        context.put("fields", browseFields);
        context.put("limit", limit);
        List<Object> params = Arrays.asList(model, "search", filter, context);
        JsonRPCResponse response = call(null, params);
        return new SearchResponse(response);
    }

    public UnlinkResponse unlink(long id) throws JsonResponseException, JsonRPCError, IOException {
        List<Object> params = Arrays.asList(model, "unlink", id);
        JsonRPCResponse response = call(null, params);
        return new UnlinkResponse(response);
    }

    public JsonRPCResponse call(Long id, List<Object> params) throws IOException, JsonResponseException, JsonRPCError {
        JsonRPCRequest req = new JsonRPCRequest("execute",
                id, params);
        JsonRPCResponse response = this.client.request(req);
        response.isOk();
        return response;
    }

}
