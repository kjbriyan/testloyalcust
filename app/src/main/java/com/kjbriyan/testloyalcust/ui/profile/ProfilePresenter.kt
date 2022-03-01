package com.kjbriyan.testloyalcust.ui.profile

import com.kjbriyan.testloyalcust.model.ResponseTransaksi
import com.kjbriyan.testloyalcust.network.InitRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfilePresenter (private val mView : ProfileView) {

    fun update(id : String,name : String,pass : String){
        mView.onShowLoading()
        InitRetrofit().getInstance().userUpdate(id,name,pass)
            .enqueue(object : Callback<ResponseTransaksi> {
                override fun onResponse(
                    call: Call<ResponseTransaksi>,
                    response: Response<ResponseTransaksi>
                ) {
                    mView.onDataloaded(response.body()?.data)
                    mView.onHideLoading()
                }

                override fun onFailure(call: Call<ResponseTransaksi>, t: Throwable) {
                    mView.onDataeror(t)
                    mView.onHideLoading()
                }

            })
    }
}