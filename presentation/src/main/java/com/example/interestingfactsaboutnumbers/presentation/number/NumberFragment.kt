package com.example.interestingfactsaboutnumbers.presentation.number

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.interestingfactsaboutnumbers.R
import com.example.interestingfactsaboutnumbers.databinding.FragmentNumberBinding
import com.example.interestingfactsaboutnumbers.presentation.fact.FactActivity
import com.example.interestingfactsaboutnumbers.presentation.main.MainActivity
import com.google.android.material.snackbar.Snackbar

class NumberFragment : Fragment() {

    private var _binding: FragmentNumberBinding? = null
    private val binding get() = _binding!!

    private val viewModel: NumberViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNumberBinding.inflate(inflater)

        setButtonGetFactHandler()
        setButtonGetRandomFactHandler()

        viewModel.factAboutNumber.value = null

        viewModel.factAboutNumber.observe(viewLifecycleOwner) {
            if(viewModel.factAboutNumber.value == null) return@observe
            val intent = Intent(requireContext(), FactActivity::class.java)
            intent.putExtra(MainActivity.INTENT_FACT_ACTIVITY_KEY, viewModel.factAboutNumber.value)
            startActivity(intent)
        }

        return binding.root
    }

    private fun setButtonGetFactHandler() {
        binding.btnGetFact.setOnClickListener {

            try {
                val number = binding.etNumber.text.toString()
                binding.etNumber.setText("")
                viewModel.getFact(number.toInt())

            } catch (e: NumberFormatException) {
                Snackbar.make(binding.root, R.string.invalid_number, Snackbar.LENGTH_SHORT)
                    .show()
                Log.e("NumberFormatException", e.message.toString())
            }
            finally {
                it.clearFocus()
            }
        }
    }

    private fun setButtonGetRandomFactHandler() {
        binding.btnGetRandomFact.setOnClickListener {
            viewModel.getRandomFact()
            it.clearFocus()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}