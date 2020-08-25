package com.example.orangetest

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.register_activity.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_activity)
        val button = findViewById<Button>(R.id.regButton)
        val pref = getPreferences(Context.MODE_PRIVATE)
        val username = pref.getString("USERNAME", "")
        val password = pref.getString("PASSWORD","")
        EnterUsername.setText(username)
        EnterPassword.setText(password)

    }

    fun register(view: View) {
        val pref = getPreferences(Context.MODE_PRIVATE)
        val editor = pref.edit()

        //save username
        editor.putString("USERNAME",EnterUsername.text.toString())

        //save Password
        editor.putString("PASSWORD" , EnterPassword.text.toString())

        editor.commit()

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }

}
