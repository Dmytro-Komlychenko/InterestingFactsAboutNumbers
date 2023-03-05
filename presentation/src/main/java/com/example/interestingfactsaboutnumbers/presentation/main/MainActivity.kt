package com.example.interestingfactsaboutnumbers.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.interestingfactsaboutnumbers.app.App
import com.example.interestingfactsaboutnumbers.databinding.ActivityMainBinding
import com.example.interestingfactsaboutnumbers.presentation.fact.FactActivity
import com.example.interestingfactsaboutnumbers.presentation.number.NumberViewModel
import com.example.interestingfactsaboutnumbers.presentation.number.NumberViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: NumberViewModel

    @Inject
    lateinit var numberViewModelFactory: NumberViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)

        (applicationContext as App).appComponent.inject(this)
        viewModel = ViewModelProvider(this, numberViewModelFactory)[NumberViewModel::class.java]

        viewModel.factAboutNumber.observe(this) {
            val intent = Intent(applicationContext, FactActivity::class.java)
            intent.putExtra(INTENT_FACT_ACTIVITY_KEY, viewModel.factAboutNumber.value)
            startActivity(intent)
        }

        setContentView(binding.root)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val INTENT_FACT_ACTIVITY_KEY = "INTENT_FACT_ACTIVITY_KEY"
    }
}