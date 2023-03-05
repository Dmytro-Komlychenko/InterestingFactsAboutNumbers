package com.example.interestingfactsaboutnumbers.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.interestingfactsaboutnumbers.R
import com.example.interestingfactsaboutnumbers.databinding.ActivityMainBinding
import com.example.interestingfactsaboutnumbers.presentation.getnumber.NumberViewModel

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: NumberViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[NumberViewModel::class.java]

        viewModel.factAboutNumber.observe(this) {
            //TODO: start fact activity
        }

        setContentView(binding.root)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}