package com.android.weatherforecastdemo.usecases

import com.android.weatherforecastdemo.objects.StateDoItem
import com.android.weatherforecastdemo.repositories.StatesRepository
import javax.inject.Inject

class StateListUseCase @Inject constructor(private val statesRepository: StatesRepository) :
    BaseUseCase.NoParamUseCase<List<StateDoItem>> {
    override suspend fun getAction(): List<StateDoItem>? {
        return statesRepository.getStates()
    }
}