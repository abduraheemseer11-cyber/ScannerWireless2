package com.scanner.wireless.model

data class DeviceModel(
    val id: String,
    val name: String,
    val ipAddress: String,
    val macAddress: String,
    val vendor: String,
    val deviceType: String,
    val isOnline: Boolean,
    val isIntruder: Boolean = false
)
