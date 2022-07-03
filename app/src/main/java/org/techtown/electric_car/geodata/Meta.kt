package org.techtown.electric_car.geodata


import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("page")
    val page: Int?,
    @SerializedName("totalCount")
    val totalCount: Int?
)