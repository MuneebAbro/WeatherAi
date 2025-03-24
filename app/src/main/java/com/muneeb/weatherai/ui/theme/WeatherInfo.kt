package com.muneeb.weatherai.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muneeb.weatherai.R

@Composable
fun WeatherInfo() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.cloudy_sunny_day), // Add your weather icon
            contentDescription = "Weather Icon",
            modifier = Modifier.size(120.dp)
        )
        Text(
            text = " 28°",
            fontSize = 48.sp,
            fontFamily = SFProDisplay,
            fontWeight = FontWeight.Medium,
            color = Color.White
        )
        Text(
            text = "Sunny",
            fontSize = 16.sp,
            fontFamily = SFProDisplay,
            fontWeight = FontWeight.Medium,
            color = Color.White
        )
        Text(
            text = "Max: 31°  Min: 25°",
            fontSize = 14.sp,
            fontFamily = SFProDisplay,
            color = Color.White
        )
    }
}
