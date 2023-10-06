package com.example.chatapp.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.chatapp.R
import com.example.chatapp.databinding.ActivityLoginBinding
import com.example.chatapp.ui.home.HomeActivity
import com.example.chatapp.ui.register.RegisterActivity
import com.example.chatapp.utlis.showAlertDialog

class LoginActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        subscribeToLiveData()
    }


    private fun initViews() {

        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        setSupportActionBar(viewBinding.toolbar)
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        viewBinding.lifecycleOwner = this
        viewBinding.vm = viewModel
    }


    private fun subscribeToLiveData() {
        viewModel.messageLiveData.observe(this) { message ->
            showAlertDialog(
                message = message.message ?: "something went wrong",
                posActionName = "Ok",
                posAction = message.onPosActionClick,
                negActionName = message.negActionName,
                negAction = message.onNegActionClick,
                isCancellable = message.isCancellable
            )
        }
        viewModel.events.observe(this, ::handleEvents)
    }

    private fun handleEvents(loginViewEvents: LoginViewEvents?) {
        when (loginViewEvents) {
            LoginViewEvents.NavigateToHome -> {
                navigateToHome()
            }

            LoginViewEvents.NavigateToRegister -> {
                navigateToRegister()
            }

            else -> {}
        }
    }

    private fun navigateToRegister() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun navigateToHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}