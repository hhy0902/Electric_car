package org.techtown.electric_car.geodata


import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("addresses")
    val addresses: List<Addresse>?,
    @SerializedName("errorMessage")
    val errorMessage: String?,
    @SerializedName("meta")
    val meta: Meta?,
    @SerializedName("status")
    val status: String?
)