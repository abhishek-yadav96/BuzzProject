package com.buzz.project.ui_activities

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.DatePicker
import android.widget.ImageButton
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.buzz.project.R
import com.buzz.project.databinding.ActivityCalendarScreenBinding
import java.time.LocalDate
import java.time.Period
import java.util.*

class CalendarScreenActivity : AppCompatActivity(),DatePickerDialog.OnDateSetListener {
    private lateinit var binding: ActivityCalendarScreenBinding
    private lateinit var dialog: Dialog
    var day = 0
    var month = 0
    var year = 0

    var savedDay = 0
    var savedMonth = 0
    var savedYear = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar_screen)
        binding = ActivityCalendarScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()

        progressBar()

        pickDate()


        binding.imageButton2.setOnClickListener{
            val intent = Intent(this , NameScreenActivity::class.java)
            startActivity(intent)
        }

        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(this , GenderScreenActivity::class.java)
            startActivity(intent)
        }


    }

    private fun getDateCalendar() {
        val cal = Calendar.getInstance()
        day = cal.get(Calendar.DAY_OF_MONTH)
        month = cal.get(Calendar.MONTH)
        year = cal.get(Calendar.YEAR)

    }

    private fun pickDate() {
        binding.editTextDate.setOnClickListener {
            getDateCalendar()

            DatePickerDialog(this, this, year, month, day).show()
        }
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        savedDay = p3
        savedMonth = p2+1
        savedYear = p1

        getDateCalendar()
        binding.editTextDate.text = "$savedDay/$savedMonth/$savedYear"
        if(getAge(savedYear,savedMonth,savedDay)>=18){
            binding.floatingActionButton.isEnabled = true
            binding.floatingActionButton.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#706DEA")))
        }
        else {
            binding.floatingActionButton.isEnabled = false
            binding.floatingActionButton.setBackgroundTintList(
                ColorStateList.valueOf(
                    Color.parseColor(
                        "#C9CDCF"
                    )
                )
            )
            dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(false)
            dialog.setContentView(R.layout.age_error_popup)
            dialog.show()
            binding.bacDimLayout.setVisibility(View.VISIBLE)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))


            var close = dialog.findViewById(R.id.btnDismiss) as ImageButton
            close.setOnClickListener {
                dialog.dismiss()
                binding.bacDimLayout.setVisibility(View.GONE)
            }

        }
    }

    @SuppressLint("NewApi")
    private fun getAge(year:Int, month: Int, dayOfMonth: Int) : Int{
        return Period.between(
            LocalDate.of(year , month , dayOfMonth),
            LocalDate.now()
        ).years
    }

    private fun progressBar(){
        binding.progressBar.max = 1000
        val currentProgress = 500
        ObjectAnimator.ofInt(binding.progressBar, "progress", currentProgress)
            .setDuration(1000)
            .start()
    }
}

