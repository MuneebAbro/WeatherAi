package com.muneeb.weatherai.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
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
fun WeatherDetails() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(24.dp)) // Rounded corners for whole container
            .background(color = colorResource(R.color.card_fill).copy(alpha = 0.2f)) // Background inside border
            .padding(vertical = 12.dp, horizontal = 16.dp), // Inner padding
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        WeatherDetailItem(R.drawable.heavy_rain, "6%")
        WeatherDetailItem(R.drawable.water, "90%")
        WeatherDetailItem(R.drawable.air, "19 km/h")
    }
}

@Composable
fun WeatherDetailItem(iconId: Int, value: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier.size(18.dp) // Smaller icon
        )
        Spacer(modifier = Modifier.width(4.dp)) // Small space between icon and text
        Text(
            text = value,
            color = Color.White,
            fontFamily = SFProDisplay,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp
        )
    }
}
