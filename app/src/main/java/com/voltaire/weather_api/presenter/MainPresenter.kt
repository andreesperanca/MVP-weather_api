package com.voltaire.weather_api.presenter

import com.voltaire.weather_api.data.RetrofitReqCallbacks
import com.voltaire.weather_api.data.SearchRemoteDataSource
import com.voltaire.weather_api.models.Result
import com.voltaire.weather_api.view.MainActivity

class MainPresenter(
    private val view : MainActivity,
    private val dataSource : SearchRemoteDataSource = SearchRemoteDataSource()
) : RetrofitReqCallbacks {

    fun findResult(cState : String) {
        dataSource.findAllInformation(cState, this)
    }

    override fun onSuccess(response: Result?) {
        view.showResult(response)
    }

    override fun onError(response: String) {
        view.showFailure(response)
    }

    override fun onComplete() {
        view.hideProgress()
    }
}