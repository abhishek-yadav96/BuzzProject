package com.buzz.project.welcome_back.ui

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.buzz.project.BaseActivity
import com.buzz.project.R
import com.buzz.project.databinding.ActivityWelcomeBackBinding
import com.buzz.project.otp_authentication_login.ui.LoginOtpActivity
import com.buzz.project.welcome.ui.WelcomeActivity

class WelcomeBackActivity : BaseActivity() {

    lateinit var binding: ActivityWelcomeBackBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_welcome_back)
        initListener()
    }

    private fun initListener(){
        binding.signUpTxt.setOnClickListener {
            val intent = Intent(this@WelcomeBackActivity, WelcomeActivity::class.java)
            startActivity(intent)
        }
        binding.btnLogin.setOnClickListener{
            val intent = Intent(this@WelcomeBackActivity,LoginOtpActivity::class.java)
            startActivity(intent)
            }

    }

}