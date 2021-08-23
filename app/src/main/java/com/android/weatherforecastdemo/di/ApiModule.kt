package com.android.weatherforecastdemo.di

import com.android.weatherforecastdemo.network.WeatherApis
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {
    private val baseUrl ="https://raw.githubusercontent.com/dilip786/"

    @Singleton
    @Provides
    fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .build()
    }

    @Singleton
    @Provides
    fun providesStatesApi(retrofit: Retrofit): WeatherApis {
        return retrofit.create(WeatherApis::class.java)
    }
}