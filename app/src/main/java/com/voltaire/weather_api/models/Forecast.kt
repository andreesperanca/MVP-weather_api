package com.voltaire.weather_api.models

data class Forecast(
    val date : String,
    val weekday : String,
    val max : String,
    val min : String,
    val description : String
)
