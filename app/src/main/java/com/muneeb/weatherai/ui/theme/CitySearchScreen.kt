package com.muneeb.weatherai.ui.theme

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.muneeb.weatherai.R
import com.muneeb.weatherai.data.City
import com.muneeb.weatherai.data.CityResponse
import com.muneeb.weatherai.data.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun CitySearchScreen() {
    var searchText by remember { mutableStateOf("") }
    var cityList by remember { mutableStateOf<List<City>>(emptyList()) }

    fun searchCities(query: String) {
        if (query.isBlank()) return

        RetrofitInstance.api.searchCities(query).enqueue(object : Callback<CityResponse> {
            override fun onResponse(call: Call<CityResponse>, response: Response<CityResponse>) {
                if (response.isSuccessful) {
                    cityList = response.body()?.results ?: emptyList()
                }
            }

            override fun onFailure(call: Call<CityResponse>, t: Throwable) {
                Log.e("API_ERROR", "Failed to fetch cities: ${t.message}")
            }
        })
    }

    GradientBackground {
        Column(modifier = Modifier.padding(16.dp)) {
            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Search City",
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(12.dp, 0.dp)
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = searchText,
                onValueChange = {
                    searchText = it
                    searchCities(it)  // Call API on text change
                },
                placeholder = { Text(text = "Enter city name") },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                singleLine = true,
                textStyle = LocalTextStyle.current.copy(color = Color.White),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = colorResource(R.color.card_fill).copy(alpha = 0.2f),
                    unfocusedContainerColor = colorResource(R.color.card_fill).copy(alpha = 0.2f),
                    focusedIndicatorColor = colorResource(R.color.highlight_outline_color),
                    unfocusedIndicatorColor = colorResource(R.color.highlight_outline_color).copy(alpha = 0.5f),
                    cursorColor = colorResource(R.color.highlight_outline_color),
                    focusedPlaceholderColor = colorResource(R.color.white).copy(alpha = 0.5f),
                    unfocusedPlaceholderColor = colorResource(R.color.white).copy(alpha = 0.5f)
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn(modifier = Modifier.fillMaxSize().padding(top = 8.dp)) {
                items(cityList) { city ->
                    Text(
                        text = "${city.name}, ${city.country}",
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { /* Handle click */ }
                            .padding(8.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(color = colorResource(R.color.card_fill).copy(alpha = 0.2f))
                            .padding(16.dp),
                    )
                }
            }
        }
    }
}