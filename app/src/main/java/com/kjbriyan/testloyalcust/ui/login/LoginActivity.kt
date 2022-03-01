package com.kjbriyan.testloyalcust.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.kjbriyan.katalogmovie.util.Helper
import com.kjbriyan.testloyalcust.MainActivity
import com.kjbriyan.testloyalcust.R
import com.kjbriyan.testloyalcust.model.DataItem
import com.kjbriyan.testloyalcust.model.ResponseLogin
import com.kjbriyan.testloyalcust.util.SharedPrefs
import com.pixplicity.easyprefs.library.Prefs

class LoginActivity : AppCompatActivity(),LoginView {
    private val TAG = "Retrofit"
    private lateinit var pb: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        pb = findViewById(R.id.pb_login)
        val presenter = LoginPresenter(this@LoginActivity)
        val uname = findViewById<TextInputEditText>(R.id.et_username).text
        val pass = findViewById<TextInputEditText>(R.id.et_pw).text
        val btn_login = findViewById<Button>(R.id.btn_login)
        val tv_signup = findViewById<TextView>(R.id.tv_signup)
        btn_login.setOnClickListener {
            presenter.login(uname.toString(), pass.toString())
            Log.d(TAG,uname.toString())
            Log.d(TAG,pass.toString())
        }
        tv_signup.setOnClickListener {
//            Helper().moveActivity(this,RegisActivity::class.java)
        }
    }

    override fun onShowLoading() {
        pb.visibility = View.VISIBLE
        Log.d(TAG, "show")
    }

    override fun onHideLoading() {
        pb.visibility = View.GONE
        Log.d(TAG, "hide")
    }

    override fun onDataloaded(results: List<DataItem?>?) {
        Log.d(TAG, "data")

        if (results?.isNotEmpty()!!) {
            Prefs.clear()
            Log.d(TAG, "data "+results.get(0)?.name)
            Prefs.putString(SharedPrefs.idUser,results.get(0)?.idUser)
            Prefs.putString(SharedPrefs.name,results.get(0)?.name)
            Prefs.putString(SharedPrefs.level,results.get(0)?.level)
            Prefs.putString(SharedPrefs.username,results.get(0)?.email)
            Prefs.putString(SharedPrefs.alamat,results.get(0)?.alamat)
            Helper().moveActivity(this@LoginActivity, MainActivity::class.java)

            Toast.makeText(this,"Sukses",Toast.LENGTH_SHORT).show()

        } else {
            Toast.makeText(this,"user password salah",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDataeror(message: Throwable) {
        Toast.makeText(this,"Data Error "+message.cause,Toast.LENGTH_SHORT).show()
    }
}