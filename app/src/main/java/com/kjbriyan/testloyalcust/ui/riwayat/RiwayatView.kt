package com.kjbriyan.testloyalcust.ui.riwayat

import com.kjbriyan.testloyalcust.model.DataItemm


interface RiwayatView {
    fun onShowLoading()
    fun onHideLoading()
    fun onDataloaded(results : List<DataItemm?>?)
    fun onDataeror(message: Throwable)
}