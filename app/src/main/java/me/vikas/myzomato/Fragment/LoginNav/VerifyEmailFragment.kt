package me.vikas.myzomato.Fragment.LoginNav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import me.vikas.myzomato.R
import me.vikas.myzomato.databinding.FragmentVerifyEmailBinding

class VerifyEmailFragment : Fragment() {

    private lateinit var dataBinding: FragmentVerifyEmailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_verify_email, container, false)

        dataBinding.btnContinueEmail.setOnClickListener {
            findNavController().navigate(R.id.action_verifyEmailFragment_to_OTPFragment)
        }

        return dataBinding.root
    }
}