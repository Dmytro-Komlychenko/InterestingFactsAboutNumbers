package com.example.interestingfactsaboutnumbers.presentation.fact

import android.R
import android.content.Intent
import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import android.os.Parcelable
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.interestingfactsaboutnumbers.databinding.ActivityFactBinding
import com.example.interestingfactsaboutnumbers.model.FactAboutNumber
import com.example.interestingfactsaboutnumbers.presentation.main.MainActivity


class FactActivity : AppCompatActivity() {

    private var _binding: ActivityFactBinding? = null
    private val binding get() = _binding!!

    private inline fun <reified T : Parcelable> Intent.parcelable(key: String): T? = when {
        SDK_INT >= 33 -> getParcelableExtra(key, T::class.java)
        else -> @Suppress("DEPRECATION") getParcelableExtra(key) as? T
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityFactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factAboutNumber = intent.parcelable<FactAboutNumber>(MainActivity.INTENT_FACT_ACTIVITY_KEY)

        binding.number.text = factAboutNumber?.number.toString()
        binding.fact.text = factAboutNumber?.fact.toString()

        supportActionBar?.apply {
            setHomeButtonEnabled(true)
            setDisplayHomeAsUpEnabled(true)
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}