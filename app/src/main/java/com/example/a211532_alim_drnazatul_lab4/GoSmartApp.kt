package com.example.a211532_alim_drnazatul_lab4

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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

@Composable
fun GoSmartApp() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { GoSmartBottomNavigationBar(navController) }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = "Home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("Home") { HomeScreenLayout() }
            composable("Stations") { StationsScreen() }
            composable("Lines") { LinesScreen() }
        }
    }
}

@Composable
fun GoSmartBottomNavigationBar(navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(top = 12.dp, bottom = 24.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.clickable { navController.navigate("Home") }
        ) {
            Icon(Icons.Default.Search, contentDescription = "Home", tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(24.dp))
            Text(text = "Home", color = MaterialTheme.colorScheme.primary, fontSize = 12.sp)
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.clickable { navController.navigate("Stations") }
        ) {
            Icon(Icons.Default.LocationOn, contentDescription = "Stations", tint = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.size(24.dp))
            Text(text = "Stations", color = MaterialTheme.colorScheme.onSurfaceVariant, fontSize = 12.sp)
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.clickable { navController.navigate("Lines") }
        ) {
            Icon(Icons.Default.List, contentDescription = "Lines", tint = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.size(24.dp))
            Text(text = "Lines", color = MaterialTheme.colorScheme.onSurfaceVariant, fontSize = 12.sp)
        }
    }
}
