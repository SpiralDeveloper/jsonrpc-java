package com.fabric.io.jsonrpc2

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun `addition_isCorrect`() {
        val req = JsonRPCClient("http://localhost:9000/api/v1/jsonrpc");
        val response = req.request(JsonRPCRequest("execute", null))
        print(response.error)
        print(response.id)
        print(response.result)
        print(response.jsonrpc)
    }
}