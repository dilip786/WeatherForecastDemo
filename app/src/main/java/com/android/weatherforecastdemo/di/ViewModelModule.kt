package com.android.weatherforecastdemo.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.weatherforecastdemo.viewModels.StateListViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class ViewModelModule {
    @Provides
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory {
        return factory
    }

    @Provides
    @IntoMap
    @ViewModelKey(StateListViewModel::class)
    fun stateListViewModel(viewModel: StateListViewModel): ViewModel {
        return viewModel
    }
}