package com.example.chatapp.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.chatapp.databinding.ActivitySplashBinding
import com.example.chatapp.ui.login.LoginActivity

class SplashActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        Handler(Looper.getMainLooper())
            .postDelayed({
                startLoginActivity()
            }, 1500)
    }

    private fun startLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}