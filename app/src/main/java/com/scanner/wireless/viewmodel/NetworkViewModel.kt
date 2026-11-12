package com.scanner.wireless.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.scanner.wireless.data.NetworkRepository
import com.scanner.wireless.model.DeviceModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class NetworkViewModel : ViewModel() {
    private val repository = NetworkRepository()

    private val _devices = MutableStateFlow<List<DeviceModel>>(emptyList())
    val devices: StateFlow<List<DeviceModel>> = _devices.asStateFlow()

    private val _isScanning = MutableStateFlow(false)
    val isScanning: StateFlow<Boolean> = _isScanning.asStateFlow()

    init {
        scanNetwork()
    }

    fun scanNetwork() {
        viewModelScope.launch {
            _isScanning.value = true
            repository.getConnectedDevices().collect { list ->
                _devices.value = list
                _isScanning.value = false
            }
        }
    }
}
