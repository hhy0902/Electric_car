package org.techtown.electric_car.searchLoad


import com.google.gson.annotations.SerializedName

data class Start(
    @SerializedName("location")
    val location: List<Double>?
)