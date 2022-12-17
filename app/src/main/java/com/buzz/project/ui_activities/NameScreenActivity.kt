package com.buzz.project.ui_activities

import android.animation.ObjectAnimator
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.buzz.project.databinding.ActivityNameScreenBinding
import com.buzz.project.otp_authentication_signup.ui.SignUpOtpActivity


class NameScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNameScreenBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNameScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()

        progressBar()

        binding.floatingActionButton.setOnClickListener{
            if(binding.editTextTextPersonName.text.toString() !="" && binding.editTextTextPersonName2.text.toString() !="" && isBuzzName(binding.editTextTextPersonName2.text.toString())) {
                val intent = Intent(this, CalendarScreenActivity::class.java)
                startActivity(intent)
            }
            else{
                binding.floatingActionButton.isEnabled = false
                binding.floatingActionButton.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#C9CDCF"))
                if(binding.editTextTextPersonName.text.toString() =="") binding.editTextTextPersonName.error = "Empty Field"
                else if (binding.editTextTextPersonName2.text.toString() =="") binding.editTextTextPersonName2.error = "Empty Field"
                else binding.editTextTextPersonName2.error = "Invalid BuzzName"

            }
        }

        binding.imageButton2.setOnClickListener{
            val intent = Intent(this, SignUpOtpActivity::class.java)
            startActivity(intent)
        }

        binding.editTextTextPersonName2.setOnClickListener{
            if(isName(binding.editTextTextPersonName.text.toString())) {
                binding.floatingActionButton.isEnabled = true
                binding.textView2.visibility = View.INVISIBLE
                binding.floatingActionButton.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#706DEA"))
            }
            else{
                binding.textView2.visibility = View.VISIBLE
            }
        }
    }

    private fun isName(string: String): Boolean {
        return string.matches("^[a-zA-Z ]*$".toRegex())
    }

    private fun progressBar(){
        binding.progressBar.max = 1000
        val currentProgress = 250
        ObjectAnimator.ofInt(binding.progressBar,"progress" , currentProgress)
            .setDuration(1000)
            .start()
    }

    private fun isBuzzName(string: String): Boolean {
        return string.matches("^[a-zA-Z0-9_]*$".toRegex())
    }

}




