package org.techtown.electric_car.kakaogeo


import com.google.gson.annotations.SerializedName

data class LatLon(
    @SerializedName("documents")
    val documents: List<Document>?,
    @SerializedName("meta")
    val meta: Meta?
)