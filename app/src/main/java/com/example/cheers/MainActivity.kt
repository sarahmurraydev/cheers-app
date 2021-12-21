package com.example.cheers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.cheers.databinding.ActivityMainBinding
import com.example.cheers.network.service
import kotlinx.coroutines.async
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var response: List<JSONObject>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val root = binding.root
        setContentView(root)

        lifecycleScope.launchWhenCreated {
            getData()
        }
    }

    private suspend fun getData() {
        val deferredResponse = lifecycleScope.async { service.getBreweries("philadelphia") }
        response = deferredResponse.await()

        binding.mainText.text = response.toString()
    }
}