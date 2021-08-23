package com.android.weatherforecastdemo.di

import com.android.weatherforecastdemo.network.WeatherApis
import com.android.weatherforecastdemo.repositories.StatesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun providesStatesRepository(weatherApis: WeatherApis): StatesRepository {
        return StatesRepository(weatherApis)
    }
}