package com.kjbriyan.testloyalcust.ui.profile

import com.kjbriyan.testloyalcust.model.DataItems

interface ProfileView {
    fun onShowLoading()
    fun onHideLoading()
    fun onDataloaded(results : List<DataItems?>?)
    fun onDataeror(message: Throwable)
}