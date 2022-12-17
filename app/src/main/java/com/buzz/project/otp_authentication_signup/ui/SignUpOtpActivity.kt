package com.buzz.project.otp_authentication_signup.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.buzz.project.BaseActivity
import com.buzz.project.R
import com.buzz.project.databinding.ActivityOtpBinding
import com.buzz.project.ui_activities.NameScreenActivity

class SignUpOtpActivity : BaseActivity() {


    lateinit var binding: ActivityOtpBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_otp)

        initListener()



    }

    private fun initListener() {
        binding.toolbar.back.visibility = View.VISIBLE

        binding.toolbar.back.setOnClickListener {
            finish()
        }

        binding.resend.isActivated = false

        binding.imageButton1.setOnClickListener {
            if (binding.phone.text.toString().length != 10) {
                binding.phoneLayout.error = "Please Enter Valid Phone Number"
            } else {
                binding.imageButton1.visibility = View.INVISIBLE
                binding.imageButton2.visibility = View.VISIBLE

                binding.imageButton2.setOnClickListener {
                    val intent = Intent(this, NameScreenActivity::class.java)
                    startActivity(intent)
                }
        }
        }
    }
}