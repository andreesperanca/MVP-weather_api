package com.voltaire.weather_api.data

import com.voltaire.weather_api.models.Result

interface RetrofitReqCallbacks {

    fun onSuccess(response: Result?)

    fun onError(response: String)

    fun onComplete()

}