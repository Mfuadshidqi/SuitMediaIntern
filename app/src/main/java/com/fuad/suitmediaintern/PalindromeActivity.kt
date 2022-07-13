package com.fuad.suitmediaintern

import android.content.Intent
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
        setupAction()
    }


    private fun checkPalindrome(){
        val text = binding.edtPalindrome.text.toString()
        if (ispalindrome(text)) {
            Toast.makeText(this, "Entered word is palindrome ", Toast.LENGTH_SHORT).show()

        } else {

            Toast.makeText(this, "Entered word is not a Palindrome", Toast.LENGTH_SHORT).show()
        }
    }

    private fun nextScreen(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun setupAction(){
        binding.btnCheck.setOnClickListener {
            checkPalindrome()
        }

        binding.btnNext.setOnClickListener{
            nextScreen()
        }
    }

    private fun ispalindrome(text: String): Boolean {
        val reverseString = text.reversed()
        return text.equals(reverseString, ignoreCase = true)
    }


    companion object {
        const val EXTRA_NAME = "extra_name"
    }
}