package com.muneeb.weatherai.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CityApiService {
    @GET("v1/search")
    fun searchCities(
        @Query("name") name: String,
        @Query("count") count: Int = 10,
        @Query("language") language: String = "en",
        @Query("format") format: String = "json"
    ): Call<CityResponse>
}
