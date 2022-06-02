package com.voltaire.weather_api.view

import android.content.Intent
import android.graphics.drawable.ClipDrawable.HORIZONTAL
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.voltaire.weather_api.R
import com.voltaire.weather_api.adapter.ForecastAdapter
import com.voltaire.weather_api.databinding.ActivityMainBinding
import com.voltaire.weather_api.databinding.ActivitySearchByCityBinding
import com.voltaire.weather_api.models.Forecast
import com.voltaire.weather_api.models.Result
import com.voltaire.weather_api.presenter.MainPresenter

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter : ForecastAdapter

    private lateinit var presenter : MainPresenter

    private lateinit var cState : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = MainPresenter(this)

        cState = intent.getStringExtra("cState").toString()
        presenter.findResult(cState)
    }

    override fun onStart() {
        super.onStart()
        binding.btnBack.setOnClickListener {
            finish()
        }
        binding.btnReload.setOnClickListener {
            presenter.findResult(cState)
        }
    }

    fun showResult(response: Result?) {
        with(binding) {
            temperatureCity.text = getString(R.string.temperature_city,response?.temp.toString())
            cityName.text = response?.city.toString()
            txtClimate.text = response?.description.toString()
            hour.text = response?.time.toString()
            humitity.text = response?.humidity.toString()
            sunriseHour.text = response?.sunrise.toString()
            sunsetHour.text = response?.sunset.toString()
            windVelocity.text = response?.wind_speedy.toString()
        }
        recyclerView = binding.rvMain
        adapter = ForecastAdapter(response?.forecast!!)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
    }

    fun showFailure(response: String) {
        Toast.makeText(this, response.toString(), Toast.LENGTH_SHORT).show()
    }

    fun hideProgress() {
        binding.loading.visibility = View.INVISIBLE
    }
}
