package com.xihadulislam.socketiowithdaggerhilt

import android.app.Application
import com.xihadulislam.socketiowithdaggerhilt.socket.SocketManager
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MyApp : Application() {

    @Inject
    lateinit var socketManager: SocketManager

    override fun onCreate() {
        super.onCreate()
        socketManager.socketConnect()
    }

}