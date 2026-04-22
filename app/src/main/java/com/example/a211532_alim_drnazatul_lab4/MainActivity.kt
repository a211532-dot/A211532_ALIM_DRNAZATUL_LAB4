package com.example.a211532_alim_drnazatul_lab4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.a211532_alim_drnazatul_lab4.ui.HomeScreenLayout
import com.example.a211532_alim_drnazatul_lab4.ui.LinesScreen
import com.example.a211532_alim_drnazatul_lab4.ui.StationsScreen
import com.example.a211532_alim_drnazatul_lab4.ui.theme.GoSmartTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GoSmartTheme {
                // 1. We call the main App function here now!
                GoSmartApp()
            }
        }
    }
}