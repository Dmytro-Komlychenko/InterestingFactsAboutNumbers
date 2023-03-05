package com.example.interestingfactsaboutnumbers.presentation.getnumber

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.interestingfactsaboutnumbers.R
import com.example.interestingfactsaboutnumbers.databinding.FragmentNumberBinding
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
        }
    }

    private fun setButtonGetRandomFactHandler() {
        binding.btnGetRandomFact.setOnClickListener {
            viewModel.getRandomFact()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}