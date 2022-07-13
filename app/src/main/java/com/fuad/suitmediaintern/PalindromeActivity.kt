package com.fuad.suitmediaintern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fuad.suitmediaintern.databinding.ActivityPalindromeBinding

class PalindromeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPalindromeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPalindromeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
    }
}