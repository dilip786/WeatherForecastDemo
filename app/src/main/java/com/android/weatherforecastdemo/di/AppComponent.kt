package com.android.weatherforecastdemo.di

import com.android.weatherforecastdemo.ui.StatesListActivity
import com.android.weatherforecastdemo.viewModels.StateListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class, RepositoryModule::class, UseCaseModule::class,ViewModelModule::class])
interface AppComponent {
    fun inject(statesListActivity: StatesListActivity)
}