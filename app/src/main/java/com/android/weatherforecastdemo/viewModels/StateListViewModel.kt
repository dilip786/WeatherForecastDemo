package com.android.weatherforecastdemo.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.weatherforecastdemo.objects.StateDoItem
import com.android.weatherforecastdemo.usecases.StateListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class StateListViewModel @Inject constructor(private val stateListUseCase: StateListUseCase) :
    ViewModel() {
    val mStatesList = MutableLiveData<List<StateDoItem>>()
    val handleStatesList: LiveData<List<StateDoItem>> get() = mStatesList

    init {
        viewModelScope.launch {
            getStatesList()
        }
    }

    suspend fun getStatesList() {
            try {
                val statesList = withContext(Dispatchers.IO) {
                    stateListUseCase.getAction()
                }
                statesList?.let {
                    mStatesList.postValue(it)
                }
            } catch (ex: Exception) {
                Log.e("ERROR", ex.message.toString())
            }
    }
}