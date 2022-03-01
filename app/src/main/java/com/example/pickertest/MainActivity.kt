package com.example.pickertest

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(){

    lateinit var tvResult : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.textView)
    }

    fun showTimePickerDialog(v: View) {

        val cal = Calendar.getInstance()
        val timeSetListener =  TimePickerDialog.OnTimeSetListener{timePicker, hour, min ->
            cal.set(Calendar.HOUR_OF_DAY, hour)
            cal.set(Calendar.MINUTE, min)

            tvResult.text = SimpleDateFormat("hh:mm:ss a").format(cal.time)

      }

        TimePickerDialog(this, timeSetListener,
            cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), false)
            .show()




      //  tvResult.text = "${TimePickerFragment().myHour} ${TimePickerFragment().myMinute}"
    }


}