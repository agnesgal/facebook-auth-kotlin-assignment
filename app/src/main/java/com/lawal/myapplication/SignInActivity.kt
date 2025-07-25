package com.lawal.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.facebook.*
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.lawal.myapplication.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding
    private lateinit var callbackManager: CallbackManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        callbackManager = CallbackManager.Factory.create()

        // Manual Sign In button
        binding.signinButton.setOnClickListener {
            val username = binding.usernameEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            if (username == "admin" && password == "1234") {
                startActivity(Intent(this, WelcomeActivity::class.java))
            } else {
                Toast.makeText(this, "Username or password is incorrect. Try again.", Toast.LENGTH_SHORT).show()
            }
        }

        // Create Account button
        binding.createAccountButton.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }

        // Facebook Login button
        binding.facebookSignUpButton.setOnClickListener {
            LoginManager.getInstance().logInWithReadPermissions(this, listOf("email", "public_profile"))
            LoginManager.getInstance().registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
                override fun onSuccess(result: LoginResult) {
                    startActivity(Intent(this@SignInActivity, WelcomeActivity::class.java))
                    finish()
                }
                override fun onCancel() {
                    Toast.makeText(this@SignInActivity, "Facebook login cancelled.", Toast.LENGTH_SHORT).show()
                }
                override fun onError(error: FacebookException) {
                    Toast.makeText(this@SignInActivity, "Facebook login failed: ${error.message}", Toast.LENGTH_LONG).show()
                }
            })
        }

        // Back button
        binding.backButton.setOnClickListener {
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager.onActivityResult(requestCode, resultCode, data)
    }
}
