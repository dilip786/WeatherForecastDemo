package com.android.weatherforecastdemo.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.weatherforecastdemo.R
import com.android.weatherforecastdemo.objects.StateDoItem
import kotlinx.android.synthetic.main.states_list_item.view.*

class StateListAdapter(private var statesList : List<StateDoItem> = mutableListOf()) : RecyclerView.Adapter<StateListAdapter.StateListViewHolder>() {

    fun refreshList(list: List<StateDoItem> = mutableListOf()){
        this.statesList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StateListViewHolder {
        return StateListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.states_list_item,parent,false))
    }

    override fun onBindViewHolder(holder: StateListViewHolder, position: Int) {
        holder.bind(statesList[position])
    }

    override fun getItemCount(): Int {
       return statesList.size
    }

    class StateListViewHolder(view: View) : RecyclerView.ViewHolder(view){
        fun bind(item: StateDoItem){
            itemView.tvCityName.text = item.name
            itemView.tvCityLatLang.text = "${item.lat}, ${item.lon}"
        }
    }
}