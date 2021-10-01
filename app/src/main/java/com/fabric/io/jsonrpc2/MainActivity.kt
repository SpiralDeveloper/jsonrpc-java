package com.fabric.io.jsonrpc2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.fabric.io.jsonrpc2.models.ModelRequest
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import java.util.HashMap

class MainActivity : AppCompatActivity() {
    @DelicateCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}