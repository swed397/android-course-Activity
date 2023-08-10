package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        button = findViewById(R.id.button_2_activity)

        button.setOnClickListener {
            val answerIntent =
                Intent().putExtra(resources.getString(R.string.key), "Hello im from activity 2!")
            setResult(RESULT_OK, answerIntent)
            finish()
        }
    }
}