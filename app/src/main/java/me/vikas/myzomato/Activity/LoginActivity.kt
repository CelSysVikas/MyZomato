package me.vikas.myzomato.Activity

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import me.vikas.myzomato.R
import me.vikas.myzomato.Util.getMenu
import me.vikas.myzomato.Util.getMenuOrderItem
import me.vikas.myzomato.Util.getRestaurant
import me.vikas.myzomato.ViewModels.MenuItemViewModel
import me.vikas.myzomato.ViewModels.OrderItemViewModel
import me.vikas.myzomato.ViewModels.RestaurantViewModel
import me.vikas.myzomato.databinding.ActivityLoginBinding

@Suppress("DEPRECATION")
class LoginActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivityLoginBinding
    private val TAG = "LoginActivity"
    private val restaurantViewModel: RestaurantViewModel by viewModels()
    private val menuItemViewModel: MenuItemViewModel by viewModels()
    private val orderItemViewModel: OrderItemViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        fullScreen()

        dataBinding.btnLogIn.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    SetupAccountActivity::class.java
                )
            )
        }

        dataBinding.ivGoogleLogin.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    HomeActivity::class.java
                )
            )
        }
        addRestaurant()
    }

    @SuppressLint("ObsoleteSdkInt")
    private fun fullScreen() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    private fun addRestaurant() {
//        val resro1 = Restaurant(
//            "NameAA", "AAA","type", "Description", "feature", false, 222, 324.34,"736","34"
//        )

        val data = restaurantViewModel.getRestaurants()

        if (data.isEmpty()) {
            restaurantViewModel.addRestaurant(getRestaurant())
            menuItemViewModel.addItem(getMenu())
            orderItemViewModel.addItem(getMenuOrderItem())
        }

//
//        var menu=restaurantViewModel.getRestaurantMenu("2")
//
//        Log.d(TAG, "addRestaurant: ${menu.restaurant} and")
//
//        menu.restaurantMenuItem?.forEach{
//            Log.d(TAG, "addRestaurant:" +
//                     "menu=  ${it}")
//        }

//        val restaurantMenuItem= RestaurantMenuItem(
//        "name","desc",327,true,734.345,9382,"2"
//        )
//        menuItemViewModel.addItem(restaurantMenuItem)
//        menuItemViewModel.menuItems().forEach { item ->
//            Log.d(TAG, "addRestaurant: ${item.items}" +
//                    "${item.menu}" +
//                    "${item.menu.id}")
//        }


//        val orderItem=Items(
//            "order1",38274,false,"asd","2"
//        )
//
//        orderItemViewModel.addItem(orderItem)

    }
}