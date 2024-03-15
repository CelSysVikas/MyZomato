package me.vikas.myzomato.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import me.vikas.myzomato.R
import me.vikas.myzomato.databinding.ActivityOrderSuccessBinding

class OrderSuccessActivity : AppCompatActivity() {

    lateinit var dataBinding:ActivityOrderSuccessBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding=DataBindingUtil.setContentView(this,R.layout.activity_order_success)

        dataBinding.btnOrderHistory.setOnClickListener {
            finish()
            startActivity(Intent(this, OrderHistoryActivity::class.java))
        }
    }
}