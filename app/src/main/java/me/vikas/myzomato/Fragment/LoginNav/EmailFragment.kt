package me.vikas.myzomato.Fragment.LoginNav

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import me.vikas.myzomato.R
import me.vikas.myzomato.databinding.FragmentEmailBinding

class EmailFragment : Fragment() {

    private lateinit var dataBinding:FragmentEmailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        dataBinding=DataBindingUtil.inflate(inflater,R.layout.fragment_email, container, false)

        dataBinding.btnContinueEmail.setOnClickListener {
            findNavController().navigate(R.id.action_emailFragment_to_nameFragment)
        }

        return dataBinding.root
    }

}