package com.fuad.suitmediaintern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.fuad.suitmediaintern.databinding.ActivityPalindromeBinding

class PalindromeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPalindromeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPalindromeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        binding.btnCheck.setOnClickListener {
            val text = binding.edtPalindrome.text.toString()
            if (ispalindrome(text)) {
                Toast.makeText(this, "Entered word is palindrome ", Toast.LENGTH_SHORT).show()

            } else {

                Toast.makeText(this, "Entered word is not a Palindrome", Toast.LENGTH_SHORT).show()

            }
        }
    }

    private fun ispalindrome(text: String): Boolean {
        val reverseString = text.reversed()
        return text.equals(reverseString, ignoreCase = true)
    }



}