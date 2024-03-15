package me.vikas.myzomato.Activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import me.vikas.myzomato.R
import me.vikas.myzomato.databinding.ActivityLoginNavBinding

class LoginNavActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivityLoginNavBinding

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        dataBinding=DataBindingUtil.setContentView(this, R.layout.activity_login_nav)

//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        val navController = navHostFragment.navController

    }

//    @SuppressLint("ObsoleteSdkInt")
//    private fun fullScreen() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
//            requireActivity().window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//            requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
//            requireActivity().window.statusBarColor = Color.TRANSPARENT
//        }
//    }
}