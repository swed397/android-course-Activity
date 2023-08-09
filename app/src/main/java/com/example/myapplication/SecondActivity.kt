package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {

    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        button = findViewById(R.id.button_2_activity)

        button.setOnClickListener {
            val answerIntent = Intent().putExtra(KEY_EXTRA, "Hello im from activity 2!")
            setResult(RESULT_OK, answerIntent)
            finish()
        }
    }
}