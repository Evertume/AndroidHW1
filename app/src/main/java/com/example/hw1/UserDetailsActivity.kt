package com.example.hw1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hw1.databinding.ActivityUserDetailsBinding

class UserDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val person = intent.getSerializableExtra("PERSON_INFO") as? Person

        if (person != null) {
            binding.textDetails.text = buildString {
                append("First Name: ${person.firstName}\n")
                append("Last Name: ${person.lastName}\n")
                append("Date of Birth: ${person.dateOfBirth}\n")
                append("Login: ${person.login}\n")
                append("Password: ${person.password}\n")
            }
        }
    }
}

