package com.fuad.suitmediaintern.ui.palindrome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.fuad.suitmediaintern.databinding.ActivityPalindromeBinding
import com.fuad.suitmediaintern.ui.main.MainActivity

class PalindromeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPalindromeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPalindromeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        setupAction()
    }


    private fun checkPalindrome() {
        val check = binding.edtPalindrome.text.toString()
        when {
            check.isEmpty() -> {
                binding.edtPalindrome.error = "Palindrome tidak boleh kosong"
            }
            else -> {
                val text = binding.edtPalindrome.text.toString()
                if (ispalindrome(text)) {
                    Toast.makeText(this, "Entered word is palindrome ", Toast.LENGTH_SHORT).show()

                } else {

                    Toast.makeText(this, "Entered word is not a Palindrome", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    private fun nextScreen(){
        val name = binding.edtName.text.toString().trim()
        when {
            name.isEmpty() -> {
                binding.edtName.error = "Nama tidak boleh kosong"
            }
            else -> {
                val nama = binding.edtName.text.toString()
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra(MainActivity.EXTRA_NAME, nama)
                startActivity(intent)
            }
        }
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



}