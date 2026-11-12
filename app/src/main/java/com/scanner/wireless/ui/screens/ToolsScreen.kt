package com.scanner.wireless.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolsScreen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Network Tools") },
                navigationIcon = { TextButton(onClick = onBack) { Text("Back") } }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Button(onClick = { }, modifier = Modifier.fillMaxWidth()) { Text("Port Scanner") }
            Button(onClick = { }, modifier = Modifier.fillMaxWidth()) { Text("Ping Device") }
            Button(onClick = { }, modifier = Modifier.fillMaxWidth()) { Text("Traceroute") }
            Button(onClick = { }, modifier = Modifier.fillMaxWidth()) { Text("DNS Lookup") }
        }
    }
}
