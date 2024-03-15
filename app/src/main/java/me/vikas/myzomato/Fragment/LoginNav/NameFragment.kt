package me.vikas.myzomato.Fragment.LoginNav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import me.vikas.myzomato.R
import me.vikas.myzomato.databinding.FragmentNameBinding

class NameFragment : Fragment() {

    private lateinit var dataBinding: FragmentNameBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_name, container, false)

        dataBinding.btnContinueEmail.setOnClickListener {
            findNavController().navigate(R.id.action_nameFragment_to_verifyEmailFragment)
        }

        return dataBinding.root
    }
}