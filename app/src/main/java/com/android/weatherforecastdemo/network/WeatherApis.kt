package com.android.weatherforecastdemo.network

import com.android.weatherforecastdemo.objects.StateDoItem
import retrofit2.http.GET

interface WeatherApis {
    @GET("Json-Files/main/states_list.json")
    suspend fun getStates(): List<StateDoItem>?
}