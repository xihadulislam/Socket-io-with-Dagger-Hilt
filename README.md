# Socket io with Dagger Hilt

<img src="https://github.com/xihadulislam/Socket-io-with-Dagger-Hilt/blob/master/ss/dagger%20hilt.jpeg" alt="alt text" style="width:200;height:200">

# Code Snippet

## Declare with lateinit var
```kt

    @Inject
    lateinit var socketManager: SocketManager


```


## Call the socketConnect method on onStart
```kt

      override fun onStart() {
        super.onStart()
        socketManager.socketConnect()
    }


```

## Call the socketDisconnect method on onDestroy
```kt

       override fun onDestroy() {
        super.onDestroy()
        socketManager.socketDisconnect()
    }


```

# File Strature 
<img src="https://github.com/xihadulislam/Socket-io-with-Dagger-Hilt/blob/master/ss/file%20structure.PNG" height="500em" /> &nbsp;



## Socket event on / off call
```kt

    private fun socketOn() {
        socketOff()
        mSocket.on(TRANSACTION_EVENT, listeners.onTransactionsListening)
    }


    private fun socketOff() {
        mSocket.off(TRANSACTION_EVENT)
    }


```
##  We will get call back into this Emitter Listener
```kt

   var onTransactionsListening =
        Emitter.Listener { args: Array<Any> ->
            try {
                val messageJson = JSONObject(args[0].toString())
                Log.d(
                    TAG,
                    "SocketHelper setListening: json----   $messageJson"
                )
            } catch (e: JSONException) {
                Log.d(
                    TAG,
                    "SocketHelper  call: error " + e.message
                )
                e.printStackTrace()
            }
        }




```


# Socket io graph
<img src="https://github.com/xihadulislam/Socket-io-with-Dagger-Hilt/blob/master/ss/socket-io.png" height="300em" />

