package me.vikas.myzomato.Fragment.LoginNav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import me.vikas.myzomato.R
import me.vikas.myzomato.databinding.FragmentOTPBinding


class OTPFragment : Fragment() {

    private lateinit var dataBinding: FragmentOTPBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_o_t_p, container, false)

        dataBinding.btnLogIn.setOnClickListener {
            findNavController().navigate(R.id.action_OTPFragment_to_locationFragment)
        }



        return dataBinding.root
    }

}