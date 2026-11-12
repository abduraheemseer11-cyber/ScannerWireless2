package com.scanner.wireless.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpeedTestScreen(onBack: () -> Unit) {
    var testing by remember { mutableStateOf(false) }
    var downloadSpeed by remember { mutableStateOf("0.0 Mbps") }
    var uploadSpeed by remember { mutableStateOf("0.0 Mbps") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Internet Speed Test") },
                navigationIcon = { TextButton(onClick = onBack) { Text("Back") } }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Download: $downloadSpeed", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(16.dp))
            Text("Upload: $uploadSpeed", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = {
                    testing = true
                    downloadSpeed = "94.5 Mbps"
                    uploadSpeed = "42.1 Mbps"
                    testing = false
                },
                enabled = !testing
            ) {
                Text(if (testing) "Testing..." else "Start Speed Test")
            }
        }
    }
}
