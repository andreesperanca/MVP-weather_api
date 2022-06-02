package com.voltaire.weather_api.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.voltaire.weather_api.R
import com.voltaire.weather_api.databinding.ForecastItemBinding
import com.voltaire.weather_api.models.Forecast

class ForecastAdapter(private val forecastList: List<Forecast> = emptyList()) :
    RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastAdapterViewHolder {
        val binding =
            ForecastItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ForecastAdapterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ForecastAdapterViewHolder, position: Int) {
        holder.bind(forecastList[position])
    }

    override fun getItemCount(): Int {
        return forecastList.size
    }

    inner class ForecastAdapterViewHolder(private val binding: ForecastItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(forecast: Forecast) {
            with(binding) {
                weekDay.text = forecast.weekday
                dateDay.text = forecast.date
                maxTemperature.text =
                    root.context.getString(R.string.temperatureMax_city, forecast.max)
                minTemperature.text =
                    root.context.getString(R.string.temperatureMin_city, forecast.min)
                descriptionDay.text = forecast.description
            }
        }
    }
}