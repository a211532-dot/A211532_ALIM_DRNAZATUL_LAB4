package com.example.a211532_alim_drnazatul_lab4.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreenLayout(viewModel: GoSmartViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    var searchQuery by remember { mutableStateOf("") }
    var isCardExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        // HEADER
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primaryContainer)
                .padding(top = 40.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu", tint = MaterialTheme.colorScheme.onPrimaryContainer)
                    Text(
                        text = "GoSMART", color = MaterialTheme.colorScheme.onPrimaryContainer, fontSize = 20.sp,
                        fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,
                        modifier = Modifier.weight(1f)
                    )
                    Box(modifier = Modifier.width(24.dp))
                }

                Row(
                    modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        placeholder = { Text("Where do you want to go?", color = Color.Gray) },
                        modifier = Modifier.weight(1f).height(56.dp),
                        singleLine = true
                    )

                    Button(
                        onClick = {
                            if (searchQuery.isNotBlank()) {
                                viewModel.updateDestination(searchQuery) // Call the ViewModel!
                            }},
                        modifier = Modifier.height(56.dp), shape = RectangleShape,
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = "Search", tint = MaterialTheme.colorScheme.onPrimary, modifier = Modifier.padding(16.dp))
                    }
                }
            }
        }

        // BODY
        Column(
            modifier = Modifier.fillMaxWidth().weight(1f).padding(16.dp)
        ) {
            // Searched place
            Card(
                modifier = Modifier.fillMaxWidth().clickable { isCardExpanded = !isCardExpanded }.animateContentSize(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = "Searched Place", color = MaterialTheme.colorScheme.onSurfaceVariant, fontSize = 12.sp)

                    Row(
                        modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = uiState.destinationName, color = MaterialTheme.colorScheme.onSurfaceVariant, fontSize = 20.sp,
                            fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 8.dp)
                        )
                        Icon(
                            imageVector = if (isCardExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                            contentDescription = "Expand details", tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }

                    if (isCardExpanded) {
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(text = " - The route to $uiState.destinationName is currently clear of traffic.", color = MaterialTheme.colorScheme.onSurfaceVariant, fontSize = 14.sp)
                        Text(text = " - Taking public transit today saves 1.5kg of CO2 emissions!", color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold, fontSize = 14.sp, modifier = Modifier.padding(top = 8.dp))
                    }
                }
            }

            // dots
            Row(modifier = Modifier.fillMaxWidth().padding(top = 8.dp, bottom = 16.dp), horizontalArrangement = Arrangement.Center) {
                Text(text = ". . .", color = MaterialTheme.colorScheme.onBackground, fontSize = 16.sp)
            }

            // FAVOURITES
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Favourites", color = MaterialTheme.colorScheme.onBackground, fontSize = 14.sp)
                Text(text = "Add", color = MaterialTheme.colorScheme.primary, fontSize = 14.sp)
            }

            Row(modifier = Modifier.fillMaxWidth().padding(top = 16.dp), verticalAlignment = Alignment.CenterVertically) {
                Icon(imageVector = Icons.Default.Place, contentDescription = "Location", tint = MaterialTheme.colorScheme.primary)
                Column(modifier = Modifier.padding(start = 16.dp).weight(1f)) {
                    Text(text = "Wawasan LRT Station", color = MaterialTheme.colorScheme.onBackground, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = "More", tint = MaterialTheme.colorScheme.onBackground)
            }
        }

    }
}