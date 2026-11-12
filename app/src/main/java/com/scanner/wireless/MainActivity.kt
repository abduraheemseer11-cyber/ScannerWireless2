package com.scanner.wireless

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.scanner.wireless.ui.screens.*
import com.scanner.wireless.ui.theme.ScannerWirelessTheme
import com.scanner.wireless.viewmodel.NetworkViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: NetworkViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScannerWirelessTheme {
                val devices by viewModel.devices.collectAsState()
                var currentScreen = androidx.compose.runtime.remember { androidx.compose.runtime.mutableStateOf("dashboard") }

                when (currentScreen.value) {
                    "dashboard" -> DashboardScreen(
                        onNavigateToScanner = { currentScreen.value = "scanner" },
                        onNavigateToSpeedTest = { currentScreen.value = "speedtest" },
                        onNavigateToTools = { currentScreen.value = "tools" }
                    )
                    "scanner" -> ScannerScreen(devices = devices, onBack = { currentScreen.value = "dashboard" })
                    "speedtest" -> SpeedTestScreen(onBack = { currentScreen.value = "dashboard" })
                    "tools" -> ToolsScreen(onBack = { currentScreen.value = "dashboard" })
                }
            }
        }
    }
}
