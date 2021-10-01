package com.fabric.io.jsonrpc2.exceptions;

public class JsonRPCError extends Exception{

    private final Object code;
    private final String message;

    public JsonRPCError(Object code, String message){
        super(message);
        this.code = code;
        this.message = message;
    }
}
