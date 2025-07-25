package com.lawal.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.lawal.myapplication.databinding.ActivitySignIn2Binding

class SignIn2Activity : AppCompatActivity() {

    private lateinit var binding : ActivitySignIn2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignIn2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signinbtn2.setOnClickListener{
            val username = binding.emailusrnmbtn.text.toString()
            val password = binding.editPassword2.text.toString()

            if (username == "admin" && password == "1234") {
                val intent = Intent(this, WelcomeActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(
                    this,
                    "Username or password is incorrect. Try again.",
                    Toast.LENGTH_SHORT
                ).show()
            }

            binding.backbtn.setOnClickListener {
                finish() // back to MainActivity
            }
        }
    }

}