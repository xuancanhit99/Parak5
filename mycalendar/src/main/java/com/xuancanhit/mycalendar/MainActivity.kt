package com.xuancanhit.mycalendar

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var edtEvent: EditText
    private lateinit var edtDate: EditText
    private lateinit var edtTime: EditText
    private lateinit var edtPost: EditText
    private lateinit var radioGroup: RadioGroup
    private lateinit var rdbGood: RadioButton
    private lateinit var rdbBad: RadioButton
    private lateinit var btnSave: Button


    private var updateEmotion = "1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Connect layout
        initUI();


        radioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { _, checkedId ->
            if (checkedId == R.id.good) {
                updateEmotion = "1"
                imageView.setImageResource(R.drawable.cheeful)
            } else {
                updateEmotion = "0"
                imageView.setImageResource(R.drawable.cry)
            }
        })

        btnSave.setOnClickListener {
            if(edtEvent.text.isNotEmpty() || edtDate.text.isNotEmpty() || edtPost.text.isNotEmpty() || edtTime.text.isNotEmpty()) {
                Toast.makeText(this, "Записано! \nСобытие: " + edtEvent.text.toString() + "\nДата: " + edtDate.text.toString() + "\nВремя: " + edtTime.text.toString() + "\nЗаметки: " + edtPost.text.toString(), Toast.LENGTH_LONG).show()
                edtEvent.setText("")
                edtTime.setText("")
                edtDate.setText("")
                edtPost.setText("")
                rdbGood.isChecked = true
            }
            else
                Toast.makeText(this, "Поля нельзя оставлять пустыми!", Toast.LENGTH_SHORT).show()
        }

    }

    private fun initUI() {
        imageView = findViewById(R.id.mood)
        edtEvent = findViewById(R.id.vevent)
        edtDate = findViewById(R.id.vdata)
        edtTime = findViewById(R.id.vtime)
        edtPost = findViewById(R.id.post)
        radioGroup = findViewById(R.id.radioGroup)
        rdbGood = findViewById(R.id.good)
        rdbBad = findViewById(R.id.bad)
        btnSave = findViewById(R.id.save)
    }

}