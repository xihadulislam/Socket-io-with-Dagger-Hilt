package com.xihadulislam.socketiowithdaggerhilt.data.models

data class DataReceiveEvent(var eventTag: String, var responseMessage: String) {

    fun isTagMatchWith(tag: String): Boolean {
        return eventTag.equals(tag, ignoreCase = true)
    }
}