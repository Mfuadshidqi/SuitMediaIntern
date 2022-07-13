package com.fuad.suitmediaintern

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide

import com.fuad.suitmediaintern.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupToolbar()
        getName()
        setupAction()
    }

    private fun getName(){
        val name = intent.getStringExtra(EXTRA_NAME)
        binding.tvName.setText(name)
    }

    private fun setupAction(){
        binding.btnChooseUser.setOnClickListener{
            val intent = Intent(this, ListUserActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupToolbar(){
        toolbar = binding.appBar
        setSupportActionBar(toolbar)
        supportActionBar?.setTitle("")

        toolbar.setNavigationOnClickListener{
            onBackPressed()
        }
    }

    private fun setUserData(user: DataItem) {
        binding.tvName.text = user.firstName
    }

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DATA = "extra_data"
    }
}