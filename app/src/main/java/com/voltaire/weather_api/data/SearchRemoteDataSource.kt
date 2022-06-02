package com.voltaire.weather_api.data

import com.voltaire.weather_api.models.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchRemoteDataSource {

    fun findAllInformation(cState: String, callback: RetrofitReqCallbacks) {
        HTTPClient.retrofit()
            .create(WeatherAPI::class.java)
            .findResult(cState)
            .enqueue(object : Callback<Result> {
                override fun onResponse(call: Call<Result>, response: Response<Result>) {
                    if (response.isSuccessful) {
                        val result = response.body()
                        callback.onSuccess(result)
                    } else {
                        val error = response.errorBody()?.toString()
                        callback.onError(error ?: "Error")
                    }
                    callback.onComplete()
                }
                override fun onFailure(call: Call<Result>, t: Throwable) {
                    callback.onError(t.message ?: "Error")
                    callback.onComplete()
                }
            })
    }
}