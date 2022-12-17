package com.buzz.project.splash_screens

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.databinding.DataBindingUtil
import com.buzz.project.BaseActivity
import com.buzz.project.R
import com.buzz.project.databinding.ActivityBuzzSplashScreenBinding
import com.buzz.project.welcome.ui.WelcomeActivity



class BuzzSplashScreen : BaseActivity() {
    private lateinit var binding: ActivityBuzzSplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_buzz_splash_screen)

        Handler().postDelayed({
            val intent = Intent(this@BuzzSplashScreen,WelcomeActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }, 1000)

    }

}