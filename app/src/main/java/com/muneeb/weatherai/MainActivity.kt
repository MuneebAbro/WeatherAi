package com.muneeb.weatherai

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.hilt.navigation.compose.hiltViewModel
import com.muneeb.weatherai.ui.theme.MainScreen
import com.muneeb.weatherai.viewmodel.CityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val cityViewModel: CityViewModel = hiltViewModel()

            // Handle result from CitySearchActivity
            val citySearchLauncher =
                rememberLauncherForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                    if (result.resultCode == Activity.RESULT_OK) {
                        val city = result.data?.getStringExtra("selected_city")
                        if (!city.isNullOrEmpty()) {
                            cityViewModel.saveCity(city)
                        }
                    }
                }

            MainScreen(
                cityViewModel = cityViewModel,
                onCityClick = {
                    citySearchLauncher.launch(Intent(this, CitySearchActivity::class.java))
                }
            )
        }
    }
}
