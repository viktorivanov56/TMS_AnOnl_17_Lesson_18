package com.example.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginEditText = findViewById<EditText>(R.id.edit_login)
        val passwordEditText = findViewById<EditText>(R.id.edit_password)
        val saveButton = findViewById<Button>(R.id.save_button)

        saveButton.isEnabled = false



        textChangeListener(loginEditText, passwordEditText, saveButton)

        saveButton.setOnClickListener {

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("login", loginEditText.text.toString())
            intent.putExtra("password", passwordEditText.text.toString())

            startActivity(intent)
        }
    }

    private fun textChangeListener(
        loginEditText: EditText,
        passwordEditText: EditText,
        saveButton: Button
    ) {
        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {

                val loginValid = loginEditText.text.length >= 6
                val passwordValid = passwordEditText.text.length >= 6

                saveButton.isEnabled = loginValid && passwordValid
            }

        }
        loginEditText.addTextChangedListener(textWatcher)
        passwordEditText.addTextChangedListener(textWatcher)

    }

}