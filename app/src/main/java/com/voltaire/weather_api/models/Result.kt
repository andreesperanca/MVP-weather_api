package com.voltaire.weather_api.models

data class Result(
    val date : String,
    val temp : String,
    val time : String,
    val description : String,
    val city : String,
    val humidity : String,
    val wind_speedy : String,
    val sunrise : String,
    val sunset : String,
    val forecast : List<Forecast>
)
