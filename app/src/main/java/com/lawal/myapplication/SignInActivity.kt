package com.lawal.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.facebook.*
import com.facebook.login.LoginResult
import com.lawal.myapplication.databinding.ActivitySignInBinding
import org.json.JSONException

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding
    private lateinit var callbackManager: CallbackManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Facebook SDK Initialization
        FacebookSdk.sdkInitialize(applicationContext)
        callbackManager = CallbackManager.Factory.create()

        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Email/Password Sign In Button
        binding.signinButton.setOnClickListener {
            val username = binding.usernameEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter both fields", Toast.LENGTH_SHORT).show()
            } else {
                // Handle email/password login here
                Toast.makeText(this, "Signed in as $username", Toast.LENGTH_SHORT).show()
            }
        }

        // Facebook Sign In Button
        binding.facebookLoginButton.setPermissions("email", "public_profile")
        binding.facebookLoginButton.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onSuccess(result: LoginResult) {
                val request = GraphRequest.newMeRequest(result.accessToken) { obj, _ ->
                    try {
                        val name = obj?.getString("name")
                        Toast.makeText(this@SignInActivity, "Facebook user: $name", Toast.LENGTH_SHORT).show()
                    } catch (e: JSONException) {
                        Toast.makeText(this@SignInActivity, "Error parsing user data", Toast.LENGTH_SHORT).show()
                    }
                }
                val parameters = Bundle()
                parameters.putString("fields", "id,name,email")
                request.parameters = parameters
                request.executeAsync()
            }

            override fun onCancel() {
                Toast.makeText(this@SignInActivity, "Facebook sign-in cancelled", Toast.LENGTH_SHORT).show()
            }

            override fun onError(error: FacebookException) {
                Toast.makeText(this@SignInActivity, "Facebook error: ${error.message}", Toast.LENGTH_LONG).show()
            }
        })

        // Back Button
        binding.backButton.setOnClickListener {
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager.onActivityResult(requestCode, resultCode, data)
    }
}
