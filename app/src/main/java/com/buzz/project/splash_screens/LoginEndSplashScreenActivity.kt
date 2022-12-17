package com.buzz.project.splash_screens

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.buzz.project.dashboard.ui.DashboardScreenActivity
import com.buzz.project.databinding.ActivityLoginEndSplashScreenBinding

class LoginEndSplashScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginEndSplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginEndSplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        Handler().postDelayed({
             val intent = Intent(this@LoginEndSplashScreenActivity , DashboardScreenActivity::class.java)
            startActivity(intent)
        },2000)


    }
}