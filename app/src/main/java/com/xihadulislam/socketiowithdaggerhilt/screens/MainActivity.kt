package com.xihadulislam.socketiowithdaggerhilt.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xihadulislam.socketiowithdaggerhilt.R
import com.xihadulislam.socketiowithdaggerhilt.socket.SocketManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var socketManager: SocketManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}