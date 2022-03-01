package com.kjbriyan.testloyalcust.ui.login

import android.util.Log
import com.kjbriyan.katalogmovie.util.Helper
import com.kjbriyan.testloyalcust.model.ResponseLogin
import com.kjbriyan.testloyalcust.network.InitRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter(private val view:LoginView) {

    private val TAG = "presenter"

    fun login(uname: String, pass: String) {
        view.onShowLoading()
        val init = InitRetrofit().getInstance().userLogin(uname, pass)
        Log.d(TAG, uname)
        init.enqueue(object : Callback<ResponseLogin> {
            override fun onResponse(call: Call<ResponseLogin>, response: Response<ResponseLogin>) {
                val res = response.body()
                view.onDataloaded(res?.data)
                view.onHideLoading()
            }
            override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                Log.d(TAG, "failure " + t.message)
                view.onHideLoading()
                view.onDataeror(t)
            }

        })

    }
}