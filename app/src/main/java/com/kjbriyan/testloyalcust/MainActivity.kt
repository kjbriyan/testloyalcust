package com.kjbriyan.testloyalcust

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.kjbriyan.katalogmovie.util.Helper
import com.kjbriyan.testloyalcust.ui.profile.ProfileFragment
import com.kjbriyan.testloyalcust.ui.riwayat.RiwayatFragment
import com.kjbriyan.testloyalcust.ui.login.LoginActivity
import com.kjbriyan.testloyalcust.util.SharedPrefs
import com.pixplicity.easyprefs.library.Prefs

class MainActivity : AppCompatActivity() {
    private val TAG = "Retrofit"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val id = Prefs.getString(SharedPrefs.idUser, "").toString()
        if (id == "") {
            Helper().moveActivity(this, LoginActivity::class.java)
            Log.d(TAG, "id " + Prefs.getString(SharedPrefs.username, ""))
            finish()

        } else {
            Log.d(TAG, "null ")
        }
        val navigation = findViewById<MeowBottomNavigation>(R.id.navigation)
        setFragment(RiwayatFragment.newIntance())
        navigation.add(MeowBottomNavigation.Model(1,R.drawable.ic_baseline_list_alt_24))
        navigation.add(MeowBottomNavigation.Model(2,R.drawable.ic_baseline_people_24))

        navigation.setOnClickMenuListener{
            when(it.id){
                1 -> setFragment(RiwayatFragment.newIntance())
                2 -> setFragment(ProfileFragment.newIntance())

                else -> ""
            }
        }
        navigation.show(1)
    }

    fun setFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.framelayout, fragment, "HomeActivity")
            .commit()
    }
}