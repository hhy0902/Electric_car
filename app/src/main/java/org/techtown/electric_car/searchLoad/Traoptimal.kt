package org.techtown.electric_car.searchLoad


import com.google.gson.annotations.SerializedName

data class Traoptimal(
    @SerializedName("guide")
    val guide: List<Guide>?,
    @SerializedName("path")
    val path: List<List<Double>>?,
    @SerializedName("section")
    val section: List<Section>?,
    @SerializedName("summary")
    val summary: Summary?
)