package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

const val KEY_EXTRA = "just key"

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.text_view)
        button = findViewById(R.id.button)

        val toSecondActivityIntent = Intent(this, SecondActivity::class.java)

        button.setOnClickListener {
            startActivityForResult(toSecondActivityIntent, ACTIVITY_ID)
        }

        setTextBySource()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == ACTIVITY_ID) {
            textView.text = "Result from Second Activity: ${data?.getStringExtra(KEY_EXTRA)}"
        }
    }

    private fun setTextBySource() {
        val uri: Uri? = intent.data

        if (uri != null) textView.text =
            "${textView.text} Open from URI" else textView.text = "${textView.text} Open default"
    }

    companion object {
        const val ACTIVITY_ID = 0
    }
}