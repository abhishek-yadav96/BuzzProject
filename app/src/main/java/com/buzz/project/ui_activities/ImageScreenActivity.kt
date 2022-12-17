package com.buzz.project.ui_activities

import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import android.content.Intent.ACTION_PICK
import android.content.res.ColorStateList
import android.graphics.Color
import android.net.Uri
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.buzz.project.R
import com.buzz.project.databinding.ActivityImageScreenBinding
import com.buzz.project.splash_screens.LoginEndSplashScreenActivity

class ImageScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImageScreenBinding

    private val contract = registerForActivityResult(ActivityResultContracts.GetContent()){
        binding.imageView2.setImageURI(it)
    }
    private val contract2 = registerForActivityResult(ActivityResultContracts.GetContent()){
        binding.imageView3.setImageURI(it)
    }
    private val contract3 = registerForActivityResult(ActivityResultContracts.GetContent()){
        binding.imageView6.setImageURI(it)
    }
    private val contract4 = registerForActivityResult(ActivityResultContracts.GetContent()){
        binding.imageView5.setImageURI(it)
    }
    private val contract5 = registerForActivityResult(ActivityResultContracts.GetContent()){
        binding.imageView4.setImageURI(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_screen)
        binding = ActivityImageScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListener()

        progressBar()

        binding.imageButton2.setOnClickListener{
            val intent = Intent(this , GenderScreenActivity::class.java)
            startActivity(intent)
        }

        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(this , LoginEndSplashScreenActivity::class.java)
            startActivity(intent)
        }

    }

    private fun progressBar(){
        binding.progressBar.max = 1000
        val currentProgress = 1000
        ObjectAnimator.ofInt(binding.progressBar, "progress", currentProgress)
            .setDuration(1000)
            .start()
    }

    private fun initListener(){
        binding.imageButton3.setOnClickListener{
            contract.launch("image/*")
            binding.imageButton3.visibility = View.INVISIBLE
            binding.imageView2.cropToPadding
            if (binding.imageView2.drawable == null){
                binding.floatingActionButton.isEnabled = true
                binding.floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#706DEA")))
            }
        }
        binding.imageButton4.setOnClickListener{
            contract2.launch("image/*")
            binding.imageButton4.visibility = View.INVISIBLE
            binding.imageView3.cropToPadding
        }
        binding.imageButton5.setOnClickListener{
            contract3.launch("image/*")
            binding.imageButton5.visibility = View.INVISIBLE
            binding.imageView6.cropToPadding
        }
        binding.imageButton6.setOnClickListener{
            contract4.launch("image/*")
            binding.imageButton6.visibility = View.INVISIBLE
            binding.imageView5.cropToPadding
        }
        binding.imageButton7.setOnClickListener{
            contract5.launch("image/*")
            binding.imageButton7.visibility = View.INVISIBLE
            binding.imageView4.cropToPadding
        }
    }


}