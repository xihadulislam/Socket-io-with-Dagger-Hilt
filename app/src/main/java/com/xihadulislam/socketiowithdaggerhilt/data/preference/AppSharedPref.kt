package com.xihadulislam.socketiowithdaggerhilt.data.preference

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppSharedPref @Inject constructor(private val kpSettings: KPSettings) {

    companion object {
        /**
         *  AppSharedPref Constants
         */
        const val DEVICE_ID = "device_id"
    }

    fun getDeviceId(): String {
        return kpSettings.getStringValue(DEVICE_ID, "")
    }

    fun setDeviceId(deviceID: String) {
        kpSettings.setStringValue(DEVICE_ID, deviceID)
    }


}