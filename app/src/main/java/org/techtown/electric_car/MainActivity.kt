package org.techtown.electric_car

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.CancellationTokenSource
import com.naver.maps.map.LocationTrackingMode
import org.techtown.electric_car.data.Car
import org.techtown.electric_car.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    var metroCd = "" // 시도
    var cityCd = "" // 군구

    private lateinit var fusedLocationProviderClient : FusedLocationProviderClient
    private var cancellationTokenSource : CancellationTokenSource? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        requestPermission()

        val url = "https://bigdata.kepco.co.kr/openapi/v1/EVcharge.do?metroCd=11&cityCd=26&apiKey=57a6FT91h23nyi00Iz5GqX41L85I53vNPL8cgG80&returnType=json"
        //val X-NCP-APIGW-API-KEY-ID = "gxidgfi46e"
        //val X-NCP-APIGW-API-KEY = "bFEPj0IOi8yjUS88rNxTtT74ntkZZWjTzPxMX5PI"
        val url2 = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query=자곡로3길 21"

        binding.search.setOnClickListener {
            metroCd = binding.sido.text.toString()
            cityCd = binding.gugon.text.toString()

            val retrofit = Retrofit.Builder()
                .baseUrl("https://bigdata.kepco.co.kr/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val retrofitService = retrofit.create(RetrofitService::class.java)
            retrofitService.getItem(metroCd, cityCd).enqueue(object : Callback<Car> {
                override fun onResponse(call: Call<Car>, response: Response<Car>) {
                    if (response.isSuccessful) {
                        val station = response.body()
                        val stationList = station?.data

                        binding.recyclerView.adapter = CarAdapter(stationList!!, LayoutInflater.from(this@MainActivity), this@MainActivity)
                        binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

                        station?.data?.forEach {
                            Log.d("testt station","${it}")
                        }
                    }
                }

                override fun onFailure(call: Call<Car>, t: Throwable) {
                    Log.d("testt onFailure message", "${t.message}")
                    Toast.makeText(this@MainActivity, "다시 시도해주세요 ", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 1000) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                Log.d("testt", "승낙")

                fetchLocation()

            } else {
                Log.d("testt", "거부")
                finish()
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("MissingPermission")
    private fun fetchLocation() {
        cancellationTokenSource = CancellationTokenSource()
        fusedLocationProviderClient.getCurrentLocation(
            LocationRequest.PRIORITY_HIGH_ACCURACY,
            cancellationTokenSource!!.token
        ).addOnSuccessListener { location ->
            try {

                Log.d("testt location ", "nowLat : ${location.latitude}, nowLon : ${location.longitude}")

            } catch (e : Exception) {
                e.printStackTrace()
                Toast.makeText(this,"error 발생 다시 시도", Toast.LENGTH_SHORT).show()
            } finally {
                Log.d("testt finish","finish")

            }
        }

    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            ),
            REQUEST_ACCESS_LOCATION_PERMISSIONS
        )
    }

    companion object {
        private const val REQUEST_ACCESS_LOCATION_PERMISSIONS = 1000
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1000

    }
}








































