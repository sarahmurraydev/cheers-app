package com.example.cheers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cheers.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: CheersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        //binding.mainText.text = getString(R.string.status, viewModel.apiStatus.value)

        val recyclerView = binding.breweryList
        recyclerView.adapter = viewModel.adapter
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
    }
}