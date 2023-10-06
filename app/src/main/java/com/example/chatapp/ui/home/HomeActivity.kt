package com.example.chatapp.ui.home

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.chatapp.R
import com.example.chatapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
    }

    private fun initViews() {
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        viewBinding.vm = viewModel
        viewBinding.lifecycleOwner = this
    }
}