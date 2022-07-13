package com.fuad.suitmediaintern

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.fuad.suitmediaintern.adapter.ListUserAdapter
import com.fuad.suitmediaintern.databinding.ActivityListUserBinding

class ListUserActivity : AppCompatActivity() {

    private lateinit var binding : ActivityListUserBinding
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupToolbar()
    }

    private fun setupToolbar(){
        toolbar = binding.appBar
        setSupportActionBar(toolbar)
        supportActionBar?.setTitle("")

        toolbar.setNavigationOnClickListener{
            onBackPressed()
        }
    }

    private fun setUserData(userData: List<DataItem>) {
        val listUserAdapter = ListUserAdapter(userData as ArrayList<DataItem>)
        binding.rvListUser.adapter = listUserAdapter
        listUserAdapter.setOnItemClickCallback(object : ListUserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: DataItem) {
                showSelectedUser(data)
            }
        })
    }

    private fun showSelectedUser(user: DataItem) {
        val detailUserIntent = Intent(this, MainActivity::class.java)
        detailUserIntent.putExtra(MainActivity.EXTRA_DATA, user.firstName)
        startActivity(detailUserIntent)
    }
}