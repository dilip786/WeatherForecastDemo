package com.android.weatherforecastdemo.di

import com.android.weatherforecastdemo.network.WeatherApis
import com.android.weatherforecastdemo.repositories.StatesRepository
import com.android.weatherforecastdemo.usecases.StateListUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun providesStatesUseCase(statesRepository: StatesRepository): StateListUseCase {
        return StateListUseCase(statesRepository)
    }
}