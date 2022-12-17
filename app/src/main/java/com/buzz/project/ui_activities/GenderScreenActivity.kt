package com.buzz.project.ui_activities

import android.animation.ObjectAnimator
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.buzz.project.R
import com.buzz.project.databinding.ActivityGenderScreenBinding


class GenderScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGenderScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_gender_screen)
        binding = ActivityGenderScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()

        progressBar()

        initListener()

        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(this , ImageScreenActivity::class.java)
            startActivity(intent)
        }

    }

    private fun progressBar(){
        binding.progressBar.max = 1000
        val currentProgress = 750
        ObjectAnimator.ofInt(binding.progressBar, "progress", currentProgress)
            .setDuration(1000)
            .start()
    }

    private fun initListener(){
        val grad = binding.textView9.background as GradientDrawable
        val grad2 = binding.textView10.background as GradientDrawable
        val grad3 = binding.textView11.background as GradientDrawable

        binding.textView9.setOnClickListener{
            binding.floatingActionButton.isEnabled = true
            binding.floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#706DEA")))
            binding.textView9.setTextColor(Color.parseColor("#ffffff"))
            binding.textView10.setTextColor(Color.parseColor("#000000"))
            binding.textView11.setTextColor(Color.parseColor("#000000"))
            grad.setColor(Color.parseColor("#706DEA"))
            grad2.setColor(Color.parseColor("#ffffff"))
            grad3.setColor(Color.parseColor("#ffffff"))
        }

        binding.textView10.setOnClickListener{
            binding.floatingActionButton.isEnabled = true
            binding.floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#706DEA")))
            binding.textView10.setTextColor(Color.parseColor("#ffffff"))
            binding.textView9.setTextColor(Color.parseColor("#000000"))
            binding.textView11.setTextColor(Color.parseColor("#000000"))
            grad2.setColor(Color.parseColor("#706DEA"))
            grad.setColor(Color.parseColor("#ffffff"))
            grad3.setColor(Color.parseColor("#ffffff"))
        }

        binding.textView11.setOnClickListener{
            binding.floatingActionButton.isEnabled = true
            binding.floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#706DEA")))
            binding.textView11.setTextColor(Color.parseColor("#ffffff"))
            binding.textView10.setTextColor(Color.parseColor("#000000"))
            binding.textView9.setTextColor(Color.parseColor("#000000"))
            grad3.setColor(Color.parseColor("#706DEA"))
            grad.setColor(Color.parseColor("#ffffff"))
            grad2.setColor(Color.parseColor("#ffffff"))
        }

        binding.imageButton2.setOnClickListener {
            val intent = Intent(this , CalendarScreenActivity::class.java)
            startActivity(intent)
        }

    }

}