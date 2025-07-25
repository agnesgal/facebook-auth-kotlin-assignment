package com.lawal.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.lawal.myapplication.databinding.ActivitySignIn2Binding
import com.lawal.myapplication.databinding.ActivitySignUp2Binding

class SignUp2Activity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUp2Binding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivitySignUp2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.createAccount.setOnClickListener(){
            val username = binding.editEmailUsername.text.toString()
            val password = binding.editPassword.text.toString()
            val confirmPassword = binding.editPassword3.text.toString()

            if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else if (password != confirmPassword) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            } else {
                // Later you will save to Firebase here
                Toast.makeText(this, "Account created (dummy for now)", Toast.LENGTH_SHORT).show()
            }
        }

        binding.backbutton1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}