package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View // something that is displayed on the screen
import android.widget.Button
import android.widget.Toast
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker = findViewById(R.id.btnDatePicker) as Button

        btnDatePicker.setOnClickListener { view -> // get view and use the view
            clickDatePicker(view) // use the view in the function with parameter of view
//            Toast.makeText(this, "Button works", Toast.LENGTH_LONG).show()
        }

    }

    fun clickDatePicker(view: View) {

        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this, DatePickerDialog.OnDateSetListener {
                view, year, month, dayOfMonth ->
//                Toast.makeText(this, "Date Picker Works", Toast.LENGTH_LONG).show()

        }
            , year
            , month
            , day).show() // dialog is type of popup
    }

}