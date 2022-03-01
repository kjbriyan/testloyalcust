package com.kjbriyan.testloyalcust.ui.riwayat


import com.kjbriyan.testloyalcust.model.ResponseRiwayat
import com.kjbriyan.testloyalcust.network.InitRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RiwayatPresenter(val view: RiwayatView) {

    fun getRiwayat(id: String) {
        view.onShowLoading()
        InitRetrofit().getInstance().riwayat(id).enqueue(object : Callback<ResponseRiwayat> {
            override fun onResponse(
                call: Call<ResponseRiwayat>,
                response: Response<ResponseRiwayat>
            ) {
                view.onDataloaded(response.body()?.data)
                view.onHideLoading()
            }

            override fun onFailure(call: Call<ResponseRiwayat>, t: Throwable) {
                view.onDataeror(t)
                view.onHideLoading()
            }

        })
    }
}