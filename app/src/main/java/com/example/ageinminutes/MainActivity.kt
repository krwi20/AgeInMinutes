package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View // something that is displayed on the screen
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

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

        val tvSelectedDate = findViewById(R.id.tvSelectedDate) as TextView

        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this, DatePickerDialog.OnDateSetListener {
                view, selectedYear, selectedMonth, selectedDayOfMonth ->
//          Toast.makeText(this, "Date Picker Works", Toast.LENGTH_LONG).show()
            Toast.makeText(this,
                "The chosen year is $selectedYear, the month is $selectedMonth and the day is $selectedDayOfMonth",
                Toast.LENGTH_LONG).show()

                val selectedDate = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"
                tvSelectedDate.setText(selectedDate)

                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH) // simple date format documentation: https://developer.android.com/reference/java/text/SimpleDateFormat

                val theDate = sdf.parse(selectedDate)

        }
            , year
            , month
            , day).show() // dialog is type of popup
    }

}