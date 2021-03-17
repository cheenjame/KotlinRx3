package com.example.kotlinrx3.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinrx3.databinding.ActivityViewBindingBinding

class ViewBindingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewBindingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewBindingBinding.inflate(
            layoutInflater
        )
        setContentView(binding.root)
        binding.activityHelloWord.text = "Hello Word"
    }
}