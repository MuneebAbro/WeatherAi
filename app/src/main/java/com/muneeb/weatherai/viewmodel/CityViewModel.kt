package com.muneeb.weatherai.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muneeb.weatherai.data.store.CityPreferenceManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CityViewModel @Inject constructor(
    private val cityPreferenceManager: CityPreferenceManager
) : ViewModel() {

    private val _selectedCity = mutableStateOf("Karachi") // Default city
    val selectedCity: State<String> = _selectedCity

    private val _cityName = MutableStateFlow("Select City") // Default value
    val cityName: StateFlow<String> = _cityName

    init {
        loadCity()
    }

    private fun loadCity() {
        viewModelScope.launch {
            val savedCity = cityPreferenceManager.getCity().first() // Get stored city
            if (!savedCity.isNullOrEmpty()) {
                _cityName.value = savedCity
                _selectedCity.value = savedCity // Update Compose state as well
            }
        }
    }

    fun saveCity(city: String) {
        viewModelScope.launch {
            cityPreferenceManager.saveCity(city)
            _cityName.value = city
            _selectedCity.value = city // Update Compose state as well
        }
    }
}
