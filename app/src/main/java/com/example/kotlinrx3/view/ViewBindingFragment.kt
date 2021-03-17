package com.example.kotlinrx3.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlinrx3.R
import com.example.kotlinrx3.databinding.FragmentViewBindingBinding


class ViewBindingFragment : Fragment() {
    private var binding: FragmentViewBindingBinding? = null
    private val viewBinding get() = binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentViewBindingBinding.inflate(inflater, container, false)
        val view = viewBinding.root
        viewBinding.fragmentHelloWord.text = "Hello Word"
        return view

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}