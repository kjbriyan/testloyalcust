package com.kjbriyan.testloyalcust.ui.login

import com.kjbriyan.testloyalcust.model.DataItem


interface LoginView {
    fun onShowLoading()
    fun onHideLoading()
    fun onDataloaded(results : List<DataItem?>?)
    fun onDataeror(message: Throwable)
}