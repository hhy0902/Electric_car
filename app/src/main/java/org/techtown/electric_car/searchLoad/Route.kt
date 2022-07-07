package org.techtown.electric_car.searchLoad


import com.google.gson.annotations.SerializedName

data class Route(
    @SerializedName("traoptimal")
    val traoptimal: List<Traoptimal>?
)