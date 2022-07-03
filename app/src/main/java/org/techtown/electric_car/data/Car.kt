package org.techtown.electric_car.data


import com.google.gson.annotations.SerializedName

data class Car(
    @SerializedName("data")
    val `data`: MutableList<Data>?
)