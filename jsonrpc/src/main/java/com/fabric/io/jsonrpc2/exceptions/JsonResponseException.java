package com.fabric.io.jsonrpc2.exceptions;

public class JsonResponseException extends Exception{

    public int code;

    public JsonResponseException(int code){
        super("JsonRPCRequest is not successful with code:"+ code);
        this.code = code;
    }
}
