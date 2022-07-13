package com.fuad.suitmediaintern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.fuad.suitmediaintern.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toolbar = binding.appBar
        setSupportActionBar(toolbar)

        toolbar.setNavigationOnClickListener{
            onBackPressed()
        }
    }
}