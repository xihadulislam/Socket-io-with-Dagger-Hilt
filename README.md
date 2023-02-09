# Socket Io with Dagger Hilt

<img src="https://github.com/xihadulislam/Socket-io-with-Dagger-Hilt/blob/master/ss/dagger%20hilt.jpeg" alt="alt text" style="width:200;height:200">

# File Strature 
<img src="https://github.com/xihadulislam/Socket-io-with-Dagger-Hilt/blob/master/ss/file%20structure.PNG" height="500em" /> &nbsp;

# Code Snippet

## diclar with lateinit var
```kt

    @Inject
    lateinit var socketManager: SocketManager


```


## call the socketConnect method on onStart()
```kt

      override fun onStart() {
        super.onStart()
        socketManager.socketConnect()
    }


```

## call the socketDisconnect method on onDestroy()
```kt

       override fun onDestroy() {
        super.onDestroy()
        socketManager.socketDisconnect()
    }


```



# Socket io graph
<img src="https://github.com/xihadulislam/Socket-io-with-Dagger-Hilt/blob/master/ss/socket-io.png" height="300em" />

