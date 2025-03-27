package com.muneeb.weatherai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.muneeb.weatherai.ui.theme.CitySearchScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CitySearchActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CitySearchScreen()
        }
    }
}