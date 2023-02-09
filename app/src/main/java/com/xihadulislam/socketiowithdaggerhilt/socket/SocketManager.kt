package com.xihadulislam.socketiowithdaggerhilt.socket

import android.util.Log
import com.xihadulislam.socketiowithdaggerhilt.utils.DebounceUtils
import com.xihadulislam.socketiowithdaggerhilt.consts.SocketConstants.TRANSACTION_EVENT
import io.socket.client.Socket
import io.socket.emitter.Emitter
import javax.inject.Inject

class SocketManager @Inject constructor(
    private val mSocket: Socket,
    private val listeners: SocketListeners
) {


    fun socketConnect() {
        if (!mSocket.connected()) {
            DebounceUtils.debounce100(object : DebounceUtils.DebounceCallback {
                override fun run() {
                    mSocket.on(Socket.EVENT_CONNECT, onConnect)
                    mSocket.on(Socket.EVENT_DISCONNECT, onDisconnect)
                    mSocket.on(Socket.EVENT_CONNECT_ERROR, onConnectError)
                    mSocket.connect()
                }
            })
        }
    }

    fun socketDisconnect() {
        socketOff()
        mSocket.disconnect()
    }

    private fun socketOn() {
        socketOff()
        mSocket.on(TRANSACTION_EVENT, listeners.onTransactionsListening)
    }


    private fun socketOff() {
        mSocket.off(TRANSACTION_EVENT)
    }

    /**
     * Listeners for Connect, Disconnect & Error
     */
    val onConnect = Emitter.Listener {
        Log.d(
            TAG,
            "SocketManager  isConnected " + mSocket.connected() + " |  isActive  " + mSocket.isActive
        )
        socketOn()
    }
    val onDisconnect = Emitter.Listener {
        Log.d(
            TAG,
            "SocketManager   Disconnected " + mSocket.connected() + " |  isActive  " + mSocket.isActive
        )
        socketOff()
    }
    val onConnectError = Emitter.Listener { args: Array<Any> ->
        Log.d(TAG, "SocketManager Error connecting..." + args[0].toString())
        socketOff()
    }


    companion object {
        private const val TAG = "SocketManager"
    }

}