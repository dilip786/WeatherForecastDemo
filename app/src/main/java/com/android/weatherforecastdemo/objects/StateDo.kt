package com.android.weatherforecastdemo.objects


import com.google.gson.annotations.SerializedName

data class StateDoItem(
    @SerializedName("lat")
    val lat: String?,
    @SerializedName("lon")
    val lon: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("state")
    val state: String?
)
