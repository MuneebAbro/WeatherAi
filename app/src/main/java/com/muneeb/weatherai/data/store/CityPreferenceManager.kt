package com.muneeb.weatherai.data.store

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

// DataStore instance
private val Context.dataStore by preferencesDataStore("weather_prefs")

@Singleton
class CityPreferenceManager @Inject constructor(@ApplicationContext private val context: Context) {

    private val CITY_KEY = stringPreferencesKey("selected_city")

    // Function to save city name
    suspend fun saveCity(cityName: String) {
        context.dataStore.edit { prefs ->
            prefs[CITY_KEY] = cityName
        }
    }

    // Function to get saved city name as Flow
    fun getCity(): Flow<String?> {
        return context.dataStore.data.map { prefs ->
            prefs[CITY_KEY]
        }
    }
}
