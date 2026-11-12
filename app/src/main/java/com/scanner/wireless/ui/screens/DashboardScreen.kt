package com.scanner.wireless.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    onNavigateToScanner: () -> Unit,
    onNavigateToSpeedTest: () -> Unit,
    onNavigateToTools: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Scanner Wireless (Fing Style)") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Network Status: Protected & Secure", style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("Gateway: 192.168.1.1 | Devices Found: 4")
                }
            }

            Button(onClick = onNavigateToScanner, modifier = Modifier.fillMaxWidth()) {
                Text("Wi-Fi Scanner & Devices")
            }

            Button(onClick = onNavigateToSpeedTest, modifier = Modifier.fillMaxWidth()) {
                Text("Internet Speed Test")
            }

            Button(onClick = onNavigateToTools, modifier = Modifier.fillMaxWidth()) {
                Text("Advanced Network Tools")
            }
        }
    }
}
