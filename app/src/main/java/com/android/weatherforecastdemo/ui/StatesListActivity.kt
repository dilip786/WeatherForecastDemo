package com.android.weatherforecastdemo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.weatherforecastdemo.R
import com.android.weatherforecastdemo.di.DaggerAppComponent
import com.android.weatherforecastdemo.viewModels.StateListViewModel
import com.android.weatherforecastdemo.di.ViewModelFactory
import kotlinx.android.synthetic.main.states_list.*
import javax.inject.Inject

class StatesListActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var viewModel: StateListViewModel
    lateinit var stateListAdapter: StateListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.states_list)
        DaggerAppComponent.create().inject(this)
        initViewModel()
        initRecyclerView()
        initObservers()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory).get(StateListViewModel::class.java)
    }

    private fun initRecyclerView(){
        stateListAdapter = StateListAdapter(mutableListOf())
        rvCities.apply {
            adapter = stateListAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun initObservers() {
        viewModel.handleStatesList.observe(this,{
            stateListAdapter.refreshList(it)
        })
    }
}