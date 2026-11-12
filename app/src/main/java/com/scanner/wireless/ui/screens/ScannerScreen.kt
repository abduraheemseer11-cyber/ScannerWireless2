package com.scanner.wireless.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.scanner.wireless.model.DeviceModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScannerScreen(devices: List<DeviceModel>, onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Connected Devices") },
                navigationIcon = {
                    TextButton(onClick = onBack) { Text("Back") }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(devices) { device ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = if (device.isIntruder) Color(0xFF451A03) else MaterialTheme.colorScheme.surface
                    )
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = device.name, style = MaterialTheme.typography.titleMedium)
                        Text(text = "IP: ${device.ipAddress} | MAC: ${device.macAddress}")
                        Text(text = "Vendor: ${device.vendor} (${device.deviceType})")
                        if (device.isIntruder) {
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(text = "⚠️ WARNING: Potential Intruder / Hidden Device!", color = Color(0xFFFF5722))
                        }
                    }
                }
            }
        }
    }
}
