package com.example.interestingfactsaboutnumbers.presentation.facts

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.interestingfactsaboutnumbers.databinding.FragmentFactItemBinding
import com.example.interestingfactsaboutnumbers.model.FactAboutNumber

class FactItemAdapter(
    private val values: List<FactAboutNumber>
) : RecyclerView.Adapter<FactItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(FragmentFactItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(values[position])
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(private val binding: FragmentFactItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(factAboutNumber: FactAboutNumber) = with(binding) {
            tvNumber.text = factAboutNumber.number.toString()
            tvFact.text = factAboutNumber.fact
        }

    }

}