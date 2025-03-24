package com.muneeb.weatherai.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muneeb.weatherai.R

@Composable
fun WeeklyForecast() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 0.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(color = colorResource(R.color.card_fill).copy(alpha = 0.2f)) // Background inside border
            .padding(16.dp)
    ) {
        Text(
            text = "Next Forecast",
            color = Color.White,
            fontSize = 18.sp,
            fontFamily = SFProDisplay,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        WeeklyWeatherItem("Monday", "13°", "10°", R.drawable.heavy_rain)
        WeeklyWeatherItem("Tuesday", "17°", "12°", R.drawable.sun)
    }
}

@Composable
fun WeeklyWeatherItem(day: String, high: String, low: String, icon: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = day, color = Color.White, fontSize = 16.sp, fontFamily = SFProDisplay, fontWeight = FontWeight.Bold)
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(40.dp)
        )
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append(high)
                }
                append("   ") // Regular separator
                withStyle(style = SpanStyle(fontWeight = FontWeight.Light, color = Color.White.copy(alpha = 0.5f))){
                    append(low)
                }
            },
            color = Color.White,
            fontSize = 14.sp,
            fontFamily = SFProDisplay
        )
    }
}
