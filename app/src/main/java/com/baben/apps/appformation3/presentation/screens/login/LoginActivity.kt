package com.baben.apps.appformation3.presentation.screens.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.baben.apps.appformation3.core.bases.BaseActivities
import com.baben.apps.appformation3.databinding.ActivityLoginBinding
import com.baben.apps.appformation3.domain.models.User
import com.baben.apps.appformation3.presentation.screens.home.HomeActivity
import com.baben.apps.appformation3.presentation.screens.signup.SignupActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import com.baben.apps.appformation3.data.remote.retrofit.RetrofitClient
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginActivity : BaseActivities() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupActions()
    }

    private fun setupActions() {
        binding.uiLoginButton.setOnClickListener(::onLoginButtonClicked)
        binding.uiSignupButton.setOnClickListener(::onSignupButtonClicked)
    }

    private fun onLoginButtonClicked(view: View?) {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val users = RetrofitClient.userApi.getUsers()
                val enteredUsername = binding.uiUsernameEditText.text.toString()
                val enteredPassword = binding.uiPasswordEditText.text.toString()
                val user = users.find { it.username == enteredUsername && it.password == enteredPassword }

                if (user != null) {
                    startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
                    finish()
                } else {
                    //message d'erreur
                }
            } catch (e: Exception) {
                // erreurs de réseau
            }
        }
    }

    private fun onSignupButtonClicked(view: View?) {
        startActivity(Intent(context, SignupActivity::class.java))
    }

}