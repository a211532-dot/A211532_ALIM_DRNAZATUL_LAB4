package com.example.a211532_alim_drnazatul_lab4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.a211532_alim_drnazatul_lab4.ui.theme.GoSmartTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoSmartTheme {
                GoSmartApp()
            }
        }
    }
}