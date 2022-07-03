package org.techtown.electric_car

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MapActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)

        val lat = intent.getStringExtra("lat")
        val lon = intent.getStringExtra("lon")

        Log.d("testt map lat / lon " ,"${lat} / ${lon}")


    }
}




























