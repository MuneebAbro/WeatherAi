package com.muneeb.weatherai.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Background Gradient
        GradientBackground{

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            TopBar()
            Spacer(modifier = Modifier.height(16.dp))
            WeatherInfo()
            Spacer(modifier = Modifier.height(16.dp))
            WeatherDetails()
            Spacer(modifier = Modifier.height(16.dp))
            HourlyForecast()
            Spacer(modifier = Modifier.height(16.dp))
            WeeklyForecast()
        }
    }
    }
}
