package com.example.a211532_alim_drnazatul_lab4.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import com.example.a211532_alim_drnazatul_lab4.data.TravelData

class GoSmartViewModel : ViewModel() {


    private val _uiState = MutableStateFlow(TravelData())


    val uiState: StateFlow<TravelData> = _uiState.asStateFlow()

    // updte data when button click
    fun updateDestination(newDestination: String) {
        _uiState.update { currentState ->
            currentState.copy(
                destinationName = newDestination
            )
        }
    }
}