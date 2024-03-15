package me.vikas.myzomato.Fragment.HomeNav

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import me.vikas.myzomato.Activity.OrderHistoryActivity
import me.vikas.myzomato.Activity.RestaurantActivity
import me.vikas.myzomato.Adapter.TrendingRestaurantAdapter
import me.vikas.myzomato.Interface.MenuItemHandler
import me.vikas.myzomato.R
import me.vikas.myzomato.ViewModels.RestaurantViewModel
import me.vikas.myzomato.databinding.FragmentDeliveryBinding

class DeliveryFragment : Fragment(), MenuItemHandler {

    private lateinit var dataBinding: FragmentDeliveryBinding
    private val restaurantViewModel: RestaurantViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_delivery, container, false)

        val list = restaurantViewModel.getRestaurants()

        dataBinding.rvTrendingRestaurants.layoutManager =
            LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        dataBinding.rvTrendingRestaurants.adapter =
            TrendingRestaurantAdapter(requireActivity(), list, DeliveryFragment())


        dataBinding.userOrders.setOnClickListener {
            requireActivity().startActivity(Intent(requireActivity(),OrderHistoryActivity::class.java))
        }
        return dataBinding.root
    }

    override fun onItemClick(id: String) {
//        val toRestroActivity = Intent(requireActivity(), RestaurantActivity::class.java)
//        toRestroActivity.putExtra("restroID", id)
//        startActivity(toRestroActivity)
    }
}