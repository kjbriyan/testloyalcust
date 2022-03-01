package com.kjbriyan.testloyalcust.ui.profile

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.kjbriyan.testloyalcust.R
import com.kjbriyan.testloyalcust.databinding.FragmentProfileBinding
import com.kjbriyan.testloyalcust.model.DataItems
import com.kjbriyan.testloyalcust.util.SharedPrefs
import com.pixplicity.easyprefs.library.Prefs

class ProfileFragment : Fragment(R.layout.fragment_profile), ProfileView {

    private lateinit var binding: FragmentProfileBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfileBinding.bind(view)
        val presenter = ProfilePresenter(this)
        var id = Prefs.getString(SharedPrefs.idUser, "").toString()
        binding.btnKirim.setOnClickListener {
            presenter.update(id, binding.etName.text.toString(), binding.etAlamat.text.toString())
        }
    }

    companion object {
        fun newIntance(): ProfileFragment {
            return ProfileFragment()
        }
    }

    override fun onShowLoading() {
        binding.pbAcc.visibility = View.VISIBLE
    }

    override fun onHideLoading() {
        binding.pbAcc.visibility = View.GONE
    }

    override fun onDataloaded(results: List<DataItems?>?) {
        Toast.makeText(requireContext(), "Berhasil Update", Toast.LENGTH_SHORT).show()
    }

    override fun onDataeror(message: Throwable) {
        Toast.makeText(requireContext(), "Error " + message.cause, Toast.LENGTH_SHORT).show()
    }
}