package me.vikas.myzomato.Activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import me.vikas.myzomato.Adapter.RestaurantMenuAdapter
import me.vikas.myzomato.Interface.OrderItemHandler
import me.vikas.myzomato.Model.RestaurantMenuItem
import me.vikas.myzomato.Model.UserCart
import me.vikas.myzomato.R
import me.vikas.myzomato.ViewModels.RestaurantViewModel
import me.vikas.myzomato.ViewModels.UserCartViewModel
import me.vikas.myzomato.databinding.ActivityRestaurantBinding

class RestaurantActivity : AppCompatActivity(), OrderItemHandler {

    private val TAG = "RestaurantActivity"
    private lateinit var dataBinding: ActivityRestaurantBinding
    private val restaurantViewModel: RestaurantViewModel by viewModels()
    private val userCartViewModel: UserCartViewModel by viewModels()
    private var restorant: String? = null
    private var userCartUpdate: UserCart? = null
    private var userCartItemsList = ArrayList<UserCart>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_restaurant)

        if (intent.getStringExtra("restroID") == null) finish()
        else intent.getStringExtra("restroID")?.let {
            initRestaurantData(it)
            initUserCart(it)
        }
    }

    private fun initRestaurantData(restroID: String) {

        restorant = restroID
        restaurantViewModel.getRestaurantMenu(restroID).observe(this, Observer {

            val restraoData = it.restaurant
            val restrauMenu = it.restaurantMenuItem

            dataBinding.apply {
                navigation.title = restraoData.name
                restrauntName.text = restraoData.name
                tvDistance.text = restraoData.distance
                tvRatings.text = "${restraoData.ratings} ratings"
                tvAverageRating.text = restraoData.averageRating.toString()
                tvFeature1.text = restraoData.feature
                tvFeature2.text = restraoData.restaurantType

                if (restraoData.isVeg) "veg" else "non-veg"

                Log.d(TAG, "initRestaurantData: $userCartItemsList")

                tvLocation.text = restraoData.location
                rvRestaurantMenu.adapter = restrauMenu?.let {
                    RestaurantMenuAdapter(
                        this@RestaurantActivity,
                        it,
                        this@RestaurantActivity
                    )
                }
            }
        })
    }

    private fun initUserCart(restroID: String) {

        userCartViewModel.getItemByRestaurantID(restroID).observe(this, Observer { data ->

            var it = ArrayList<UserCart>()

            for (item in data) {
                if (!item.isOrderCompleted)
                    it.add(item)
            }

            var totalItemCount = 0

            if (it.isNotEmpty()) {
                for (count in it) {
                    userCartItemsList.add(count)
                    totalItemCount += count.itemCount1
                }

                dataBinding.userCartItems.visibility = View.VISIBLE
                dataBinding.itemCount = totalItemCount.toString()
                dataBinding.userCartItems.setOnClickListener {
                    val toUserCart = Intent(this, UserCartActivity::class.java)
                    toUserCart.putExtra("restroID", restorant)
                    startActivity(toUserCart)
                }
            } else {
                dataBinding.userCartItems.visibility = View.GONE
            }
        })
    }

    override fun updateCart(item: RestaurantMenuItem, count: Int) {

        if (checkItemExist(item.id)) {
            if (count == 0) {
                userCartViewModel.clearCartItem(userCartUpdate!!)
                return
            }

            userCartUpdate?.itemCount1 = count
            userCartViewModel.updateCartItem(userCartUpdate!!)

        } else {
            val userCart = restorant?.let {
                UserCart(
                    restroID = it,
                    menuID = item.id.toString(),
                    basePrice1 = item.price,
                    itemCount1 = count
                )
            }
            userCartViewModel.addItem(userCart!!)
        }
    }

    private fun checkItemExist(id: Int): Boolean {
        userCartViewModel.getItemByMenuID2(id.toString())?.let {
            userCartUpdate = it
            return true
        }
        return false
    }

}