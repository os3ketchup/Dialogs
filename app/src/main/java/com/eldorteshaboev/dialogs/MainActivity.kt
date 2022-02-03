package com.eldorteshaboev.dialogs

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.appcompat.app.AlertDialog
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.Snackbar.LENGTH_SHORT
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import com.google.android.material.snackbar.Snackbar.make as make1

class MainActivity : AppCompatActivity() {
    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cv_alertDialog.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this).create()
            alertDialog.setTitle("Alert dialog title")
            alertDialog.setMessage("Alert dialog message")
            alertDialog.show()
        }


        cv_customDialog.setOnClickListener {
            val builder = AlertDialog.Builder(this).create()
            val customDialog =
                LayoutInflater.from(this).inflate(R.layout.custom_dialog, null, false)
            builder.setView(customDialog)
            builder.show()
        }


        cv_fragmentDialog.setOnClickListener {
            val builder = AlertDialog.Builder(this).create()
            val fragmentDialog =
                LayoutInflater.from(this).inflate(R.layout.fragment_my_dialog, null, false)
            builder.setView(fragmentDialog)
            builder.show()
        }

        cv_DatePicker.setOnClickListener {
            clickDatePicker(it)
        }

        cv_timePickerDialog.setOnClickListener {
            clickTimePicker(it)
        }

        cv_bottom_sheetDialog.setOnClickListener {
            val sheetDialog = BottomSheetDialog(this)
            sheetDialog.setContentView(
                layoutInflater.inflate(
                    R.layout.fragment_my_dialog,
                    null,
                    false
                )
            )
            sheetDialog.show()
        }

        cv_snackBar.setOnClickListener {
            val snackBar = Snackbar.make(it, "this is snackBar", LENGTH_SHORT)


            snackBar.setAction(
                "CLICK"
            ) { makeText(this@MainActivity, "Clicked", Toast.LENGTH_SHORT).show() }


            snackBar.show()

        }


    }

    private fun clickTimePicker(view: View) {
        val myCalendar = Calendar.getInstance()
        val hours = myCalendar.get(Calendar.HOUR)
        val minutes = myCalendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(this,
            { _, hourOfDay, minute ->
                Toast.makeText(this, "$hourOfDay: $minute", Toast.LENGTH_SHORT).show()


            }, hours, minutes, true
        )

        timePickerDialog.show()

    }

    private fun clickDatePicker(view: View) {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val dayOfMonth = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(
            this, DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
                Toast.makeText(
                    this,
                    " - $year - ${month + 1} - $dayOfMonth - ",
                    Toast.LENGTH_SHORT
                ).show()
            },
            year, month, dayOfMonth
        ).show()
    }

}