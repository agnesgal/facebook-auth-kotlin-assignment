package com.lawal.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lawal.myapplication.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Show a simple welcome text or whatever you want
        binding.welcomeMessage.text = "Welcome! 🎉"
    }
}
