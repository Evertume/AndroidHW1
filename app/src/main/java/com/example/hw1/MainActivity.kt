package com.example.hw1

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstnametext = findViewById<EditText>(R.id.firstname)
        val lastnametext = findViewById<EditText>(R.id.lastname)
        val agetext = findViewById<EditText>(R.id.age)
        val usernametext = findViewById<EditText>(R.id.username)
        val passwordtext = findViewById<EditText>(R.id.password)
        val registerbutton = findViewById<Button>(R.id.registerbutton)

        registerbutton.setOnClickListener {
            val firstname = firstnametext.text.toString()
            val lastname = lastnametext.text.toString()
            val age = agetext.text.toString()
            val username = usernametext.text.toString()
            val password = passwordtext.text.toString()

            if (isEmpty(firstname) || isEmpty(lastname) || isEmpty(age) || isEmpty(username) || isEmpty(password)) {
                Toast.makeText(this@MainActivity, "Please fill all fields", Toast.LENGTH_LONG).show()
            } else {
                val person = Person(firstname, lastname, age, username, password)
                val intent = Intent(this@MainActivity, UserDetailsActivity::class.java)
                intent.putExtra("PERSON_INFO", person)
                startActivity(intent)
            }
        }
    }
}
