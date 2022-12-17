@file:Suppress("NAME_SHADOWING")

package com.buzz.project.welcome.ui

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.buzz.project.BaseActivity
import com.buzz.project.R
import com.buzz.project.databinding.ActivityWelcomeBinding
import com.buzz.project.otp_authentication_signup.ui.SignUpOtpActivity
import com.buzz.project.welcome_back.ui.WelcomeBackActivity

class WelcomeActivity : BaseActivity() {

    lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_welcome)

        initListener()
    }
    private fun initListener(){
        binding.signUpBtn.setOnClickListener {
            val intent = Intent(this@WelcomeActivity, SignUpOtpActivity::class.java)
            startActivity(intent)
        }
        binding.loginTxt.setOnClickListener{
            val intent = Intent(this@WelcomeActivity,WelcomeBackActivity::class.java)
            startActivity(intent)
        }
    }
}