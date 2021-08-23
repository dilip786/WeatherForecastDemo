package com.android.weatherforecastdemo.repositories

import com.android.weatherforecastdemo.network.WeatherApis
import com.android.weatherforecastdemo.objects.StateDoItem
import javax.inject.Inject

class StatesRepository @Inject constructor(private val weatherApis: WeatherApis) {
    suspend fun getStates(): List<StateDoItem>? {
        return weatherApis.getStates()
    }
}