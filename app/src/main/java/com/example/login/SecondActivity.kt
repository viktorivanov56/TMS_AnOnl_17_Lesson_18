package com.example.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val login = intent.getStringExtra("login")
        val password = intent.getStringExtra("password")

        findViewById<TextView>(R.id.data).text = "login: $login\n Password: $password"
    }
}