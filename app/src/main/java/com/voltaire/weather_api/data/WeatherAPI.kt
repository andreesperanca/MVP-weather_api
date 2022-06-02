package com.voltaire.weather_api.data

import com.voltaire.weather_api.models.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {

        @GET("https://api.hgbrasil.com/weather?&fields=only_results,date,time,description,weekday,temp,city,humidity,wind_speedy,sunrise,sunset,forecast,max,min&key=b5cf300f&city_name=Resende,RJ")
        fun findResult(@Query("city_name") cState : String, @Query("key") key : String = HTTPClient.API_KEY) : Call<Result>

}