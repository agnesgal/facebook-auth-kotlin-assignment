package com.lawal.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lawal.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // initialize view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Sign In button
        binding.buttonSignIn.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

        // Sign Up button
        binding.buttonSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        // Sign In 2 button
        binding.buttonSignIn2.setOnClickListener {
            val intent = Intent(this, SignIn2Activity::class.java)
            startActivity(intent)
        }

        // Sign Up 2 button
        binding.buttonSignUp2.setOnClickListener {
            val intent = Intent(this, SignUp2Activity::class.java)
            startActivity(intent)
        }

        // Updates button
        binding.buttonUpdates.setOnClickListener {
            val intent = Intent(this, UpdatesActivity::class.java)
            startActivity(intent)
        }
    }
}