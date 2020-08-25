package com.example.orangetest

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val goregister = findViewById<Button>(R.id.goregister)
        val login= findViewById<Button>(R.id.login)
        val Username = findViewById<EditText>(R.id.Username)
        val Password = findViewById<EditText>(R.id.Password)
        val sharedPreferences: SharedPreferences = this.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        goregister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
        login.setOnClickListener {
            if (Username != null && Password != null){
                val usern: String =  Username.text.toString()
                val pass: String =  Password.text.toString()
                if(sharedPreferences.contains(usern) && sharedPreferences.contains(pass)){
                    Toast.makeText(getApplicationContext(),"Sign-in successful",Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(getApplicationContext(),"Wrong Credentials !",Toast.LENGTH_SHORT).show();

                }
            }
            else{
                Toast.makeText(getApplicationContext(),"Please enter both Username and Password",Toast.LENGTH_SHORT).show();

            }
        }

    }
}