package com.fuad.suitmediaintern.ui.listuser

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.fuad.suitmediaintern.ui.main.MainActivity
import com.fuad.suitmediaintern.adapter.ListUserAdapter
import com.fuad.suitmediaintern.adapter.LoadingStateAdapter
import com.fuad.suitmediaintern.databinding.ActivityListUserBinding
import com.fuad.suitmediaintern.local.room.UsersDatabase
import com.fuad.suitmediaintern.retrofit.ApiConfig

class ListUserActivity : AppCompatActivity() {

    private lateinit var binding : ActivityListUserBinding
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private lateinit var usersViewModel : ListUserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupToolbar()

        setupViewModel()

        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            binding.rvListUser.layoutManager = GridLayoutManager(this, 1)
        } else {
            binding.rvListUser.layoutManager = LinearLayoutManager(this)
        }



    }

    private fun setupViewModel() {
        val apiService = ApiConfig.getApiService()
        val database = UsersDatabase.getDatabase(this)
        val factory = ListUserViewModelFactory(apiService, database)
        usersViewModel = ViewModelProvider(
            this,
            factory
        )[ListUserViewModel::class.java]

        val adapter = ListUserAdapter()
        binding.rvListUser.adapter = adapter.withLoadStateFooter(
            footer = LoadingStateAdapter {
                adapter.retry()
            }
        )
        usersViewModel.getUsers().observe(this) { result ->
            adapter.submitData(lifecycle, result)
        }
    }

    private fun setupToolbar(){
        toolbar = binding.appBar
        setSupportActionBar(toolbar)
        supportActionBar?.setTitle("")

        toolbar.setNavigationOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}