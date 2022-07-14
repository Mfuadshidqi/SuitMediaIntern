package com.fuad.suitmediaintern.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fuad.suitmediaintern.response.DataItem

class MainViewModel : ViewModel() {
    private val _countUser = MutableLiveData<List<DataItem>>()
    val countUser: LiveData<List<DataItem>> = _countUser
}