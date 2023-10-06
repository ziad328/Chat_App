package com.example.chatapp.ui.home

import androidx.lifecycle.ViewModel
import com.example.chatapp.utlis.SingleLiveEvent

class HomeViewModel : ViewModel() {
    val events = SingleLiveEvent<HomeViewEvents>()
}