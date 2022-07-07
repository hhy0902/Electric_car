package org.techtown.electric_car.searchLoad


import com.google.gson.annotations.SerializedName

data class Goal(
    @SerializedName("dir")
    val dir: Int?,
    @SerializedName("location")
    val location: List<Double>?
)