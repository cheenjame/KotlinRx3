package com.example.kotlinrx3.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinrx3.R
import com.example.kotlinrx3.databinding.ActivityLoginBinding
import com.example.kotlinrx3.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.inflate(
            layoutInflater, R.layout.activity_login, null,
            false
        )
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.loginActivityButton.setOnClickListener {
            viewModel.login(
                binding.loginActivityAccount.text.toString(),
                binding.loginActivityPassword.text.toString(),
                "C3ZDU16409000964", this
            )
        }
    }
}