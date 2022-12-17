package com.buzz.project.otp_authentication_login.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.buzz.project.R
import com.buzz.project.databinding.ActivityLoginOtpBinding

class LoginOtpActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginOtpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login_otp)

        initListener()
    }

    private fun initListener(){
        binding.toolbar.back.visibility = View.VISIBLE

        binding.toolbar.back.setOnClickListener {
            finish()
        }
    }
}