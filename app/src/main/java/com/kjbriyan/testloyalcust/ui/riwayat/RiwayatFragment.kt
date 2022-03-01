package com.kjbriyan.testloyalcust.ui.riwayat

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.kjbriyan.testloyalcust.R
import com.kjbriyan.testloyalcust.adapter.RvAdapterTransaksi
import com.kjbriyan.testloyalcust.databinding.FragmentRiwayatBinding
import com.kjbriyan.testloyalcust.model.DataItemm
import com.kjbriyan.testloyalcust.util.SharedPrefs
import com.pixplicity.easyprefs.library.Prefs

class RiwayatFragment : Fragment(R.layout.fragment_riwayat), RiwayatView {
    lateinit var adapterNow: RvAdapterTransaksi
    private lateinit var binding: FragmentRiwayatBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRiwayatBinding.bind(view)
        val presenter = RiwayatPresenter(this)
        var id = Prefs.getString(SharedPrefs.idUser, "").toString()
        activity.let {
//            presenter.getRiwayat(id)
        }
    }

    companion object {
        fun newIntance(): RiwayatFragment {
            return RiwayatFragment()
        }
    }

    override fun onShowLoading() {

    }

    override fun onHideLoading() {

    }

    override fun onDataloaded(results: List<DataItemm?>?) {

    }

    override fun onDataeror(message: Throwable) {

    }
}