package com.shevikina.lomtegram

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shevikina.lomtegram.screens.NavigationScreen
import com.shevikina.lomtegram.ui.theme.LomtegramTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LomtegramTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp, 64.dp, 32.dp, 16.dp)
                ) {
                    NavigationScreen()
                }
            }
        }
    }
}