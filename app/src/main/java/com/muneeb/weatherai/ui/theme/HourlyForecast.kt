package com.muneeb.weatherai.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muneeb.weatherai.R

@Composable
fun HourlyForecast() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 0.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color = colorResource(R.color.card_fill).copy(alpha = 0.2f)) // Background inside border
            .padding(16.dp),
    ) {
        // "Today" Label
        Text(
            text = "Today",
            color = Color.White,
            fontSize = 18.sp,
            fontFamily = SFProDisplay,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Row of weather items
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            WeatherHourCard("29°C", R.drawable.sun, "15:00", isSelected = false)
            WeatherHourCard("26°C", R.drawable.cloud, "16:00", isSelected = false)
            WeatherHourCard("24°C", R.drawable.cloud, "17:00", isSelected = true) // Selected hour
            WeatherHourCard("23°C", R.drawable.moon, "18:00", isSelected = false)
        }
    }
}
@Composable
fun WeatherHourCard(temp: String, icon: Int, time: String, isSelected: Boolean) {
    Column(
        modifier = Modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(12.dp))
            .border(
                width = if (isSelected) 2.dp else 0.dp, // Add border for selected item
                color = if (isSelected) colorResource(id = R.color.highlight_outline_color) else Color.Transparent,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(vertical = 16.dp, horizontal = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = temp, color = Color.White, fontSize = 14.sp, fontFamily = SFProDisplay)

        Spacer(modifier = Modifier.height(12.dp)) // Added space here ⬆️

        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(32.dp) // Smaller icon
        )

        Spacer(modifier = Modifier.height(12.dp)) // Added space here ⬆️

        Text(text = time, color = Color.White, fontSize = 12.sp, fontFamily = SFProDisplay)
    }
}
