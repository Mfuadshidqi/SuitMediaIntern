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
        setupToolbar()
        getName()
    }

    private fun getName(){
        val name = intent.getStringExtra(EXTRA_NAME)
        binding.tvName.setText(name)
    }

    private fun setupToolbar(){
        toolbar = binding.appBar
        setSupportActionBar(toolbar)
        supportActionBar?.setTitle("")

        toolbar.setNavigationOnClickListener{
            onBackPressed()
        }
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
    }
}