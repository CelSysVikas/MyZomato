package me.vikas.myzomato.Activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import me.vikas.myzomato.Adapter.UserCartAdapter
import me.vikas.myzomato.Interface.CartItemHandler
import me.vikas.myzomato.Model.CompletedUserCart
import me.vikas.myzomato.Model.UserCart
import me.vikas.myzomato.R
import me.vikas.myzomato.ViewModels.UserCartViewModel
import me.vikas.myzomato.databinding.ActivityUserCartBinding

class UserCartActivity : AppCompatActivity(), CartItemHandler {

    private lateinit var dataBinding: ActivityUserCartBinding
    private val userCartViewModel: UserCartViewModel by viewModels()
    private var userCartUpdate: UserCart? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_cart)

        if (intent.getStringExtra("restroID") == null) finish()
        else intent.getStringExtra("restroID")?.let {
            initCartData(it)
        }

    }

    private fun initCartData(it: String) {
        userCartViewModel.getUserCartByRestaurantIDItems(it).observe(this, Observer {

            if (it.isEmpty()) {
                finish()
            } else {
                dataBinding.rvCartItems.layoutManager =
                    LinearLayoutManager(this@UserCartActivity, LinearLayoutManager.VERTICAL, false)
                dataBinding.rvCartItems.adapter =
                    UserCartAdapter(this@UserCartActivity, it, this@UserCartActivity)
                dataBinding.navigation.title = it[0].restaurant.name

                var sum = 0
                for (item in it) {
                    sum += item.cartItem.itemCount1 * item.cartItem.basePrice1
                }
                dataBinding.amount=sum.toString()

                dataBinding.btnSuccess.setOnClickListener { v ->
                    for (item in it) {
                        var completedItem = CompletedUserCart(
                            id = item.cartItem.id,
                            restroID = item.cartItem.restroID,
                            menuID = item.cartItem.menuID,
                            orderItemID = item.cartItem.orderItemID.toString(),
                            basePrice1 = item.cartItem.basePrice1,
                            itemCount1 = item.cartItem.itemCount1
                        )

                        userCartViewModel.clearCartItem(item.cartItem)
                        userCartViewModel.addCompletedOrder(completedItem)


                    }

                    finish()
                    startActivity(Intent(this, OrderSuccessActivity::class.java))
                }
            }

        })

    }


    override fun onItemClick(item: UserCart, count: Int) {
        if (count < 1) {
            userCartViewModel.clearCartItem(item)
        }

        item.itemCount1 = count
        userCartViewModel.updateCartItem(item)
    }

    fun createCompletedCart() {

    }
}