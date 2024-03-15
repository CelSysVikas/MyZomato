package me.vikas.myzomato.Activity

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import me.vikas.myzomato.Adapter.OrdersHistoryAdapter
import me.vikas.myzomato.Interface.CartItemHandler
import me.vikas.myzomato.Model.UserCart
import me.vikas.myzomato.R
import me.vikas.myzomato.ViewModels.UserCartViewModel
import me.vikas.myzomato.databinding.ActivityOrderHistoryBinding

class OrderHistoryActivity : AppCompatActivity(), CartItemHandler {

    private lateinit var dataBinding: ActivityOrderHistoryBinding
    private val userCartViewModel: UserCartViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_order_history)



        userCartViewModel.getCompletedOrders().let {
            if (it.isEmpty()) {

            } else {
                dataBinding.noDataFound.visibility=View.GONE
                dataBinding.rvOrderHistory.visibility=View.VISIBLE

                dataBinding.rvOrderHistory.layoutManager =
                    LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                dataBinding.rvOrderHistory.adapter =
                    OrdersHistoryAdapter(this@OrderHistoryActivity, it, this)
            }
        }
    }

    override fun onItemClick(item: UserCart, count: Int) {

    }
}