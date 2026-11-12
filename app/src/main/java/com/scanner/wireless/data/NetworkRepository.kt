package com.scanner.wireless.data

import com.scanner.wireless.model.DeviceModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NetworkRepository {
    fun getConnectedDevices(): Flow<List<DeviceModel>> = flow {
        // Simulated network discovery matching Fing capabilities
        emit(
            listOf(
                DeviceModel("1", "Wi-Fi Router (Gateway)", "192.168.1.1", "00:11:22:33:44:55", "TP-Link Technologies", "Router", true),
                DeviceModel("2", "My Android Phone", "192.168.1.10", "AA:BB:CC:DD:EE:FF", "Google Pixel", "Smartphone", true),
                DeviceModel("3", "Smart TV Living Room", "192.168.1.15", "11:22:33:44:55:66", "Samsung Electronics", "Smart TV", true),
                DeviceModel("4", "Unknown Intruder Device", "192.168.1.45", "FF:EE:DD:CC:BB:AA", "Espressif Systems", "IoT / Hidden Cam", true, true)
            )
        )
    }
}
