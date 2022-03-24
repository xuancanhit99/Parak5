package com.xuancanhit.pr524

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import kotlin.math.log
import kotlin.math.roundToInt


class MainActivity : AppCompatActivity() {
    private lateinit var edtKm: EditText
    private lateinit var edtM: EditText
    private lateinit var edtDm: EditText
    private lateinit var edtCm: EditText
    private lateinit var edtMm: EditText

    private lateinit var btnInspect: Button

    private lateinit var tvResult: TextView

    private lateinit var imAnswer: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Connect layout
        initUI();

        btnInspect.setOnClickListener {
            hideSoftKeyboard(it)
            if (edtKm.text.isNotEmpty() && edtM.text.isNotEmpty() && edtDm.text.isNotEmpty() && edtCm.text.isNotEmpty() && edtMm.text.isNotEmpty()) {

                var numKm: Float = edtKm.text.toString().toFloat()
                var numM: Float = edtM.text.toString().toFloat()
                var numDm: Float = edtDm.text.toString().toFloat()
                var numCm: Float = edtCm.text.toString().toFloat()
                var numMm: Float = edtMm.text.toString().toFloat()

                if (numKm * 1000 == numM && numM * 10 == numDm && numM * 100 == numCm && numM * 1000 == numMm) {
                    tvResult.text = getString(R.string.good)
                    tvResult.setTextColor(resources.getColor(R.color.blue))
                    imAnswer.setImageResource(R.drawable.cool)
                    //Toast.makeText(this, "Oke", Toast.LENGTH_SHORT).show()
                } else {
                    tvResult.text = getString(R.string.bad)
                    tvResult.setTextColor(ResourcesCompat.getColor(resources, R.color.red, null))
                    imAnswer.setImageResource(R.drawable.bad)
                    //imAnswer.setBackgroundResource(R.drawable.bad)
                }
                //Log.d("my err", a.toString())
            } else
                Toast.makeText(this, "Поля нельзя оставлять пустыми!", Toast.LENGTH_SHORT)
                    .show()
        }

        imAnswer.setOnClickListener {
            var transparency: Float = imAnswer.alpha

            if (transparency.toString() == "0.1")
                imAnswer.alpha = 1.0.toFloat()
            else
                imAnswer.alpha = (((transparency - 0.1) * 10.0).roundToInt() / 10.0).toFloat()
        }

    }

    private fun hideSoftKeyboard(view: View) {
        val manager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        manager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun initUI() {
        edtKm = findViewById(R.id.km)
        edtM = findViewById(R.id.m)
        edtDm = findViewById(R.id.dm)
        edtCm = findViewById(R.id.sm)
        edtMm = findViewById(R.id.mm)
        btnInspect = findViewById(R.id.inspect)
        tvResult = findViewById(R.id.result)
        imAnswer = findViewById(R.id.answer)
    }
}