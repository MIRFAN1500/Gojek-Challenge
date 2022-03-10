package com.binar.gojekchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.binar.gojekchallenge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val menuItemIds = listOf(R.id.navigation_promo, R.id.navigation_chat)
        menuItemIds.forEach { menuItemId ->
            val badge = binding.navView.getOrCreateBadge(menuItemId)
            badge.isVisible = true
        }
    }
}