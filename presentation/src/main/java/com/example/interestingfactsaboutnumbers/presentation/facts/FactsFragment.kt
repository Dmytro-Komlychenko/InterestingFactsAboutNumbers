package com.example.interestingfactsaboutnumbers.presentation.facts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.interestingfactsaboutnumbers.databinding.FragmentFactsBinding
import com.example.interestingfactsaboutnumbers.model.FactAboutNumber

class FactsFragment : Fragment() {

    private var _binding: FragmentFactsBinding? = null
    private val binding get() = _binding!!

    lateinit var adapter: FactItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFactsBinding.inflate(layoutInflater)

        val fan1 = FactAboutNumber(0, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec sodales, justo sed feugiat dignissim, ex nulla posuere massa, vel ultrices augue tellus venenatis justo. Donec tincidunt leo id aliquam fermentum. Donec sit amet erat ut neque laoreet consequat. In id sapien nunc. Nulla vel diam et quam posuere dapibus. Nam maximus dui diam, vitae iaculis ex euismod nec. Nullam porta mollis sem ac elementum. Duis justo purus, sollicitudin id rutrum id, lacinia eu turpis. Nulla elementum dui et aliquam dignissim. Etiam in nisi laoreet, accumsan lorem a, efficitur magna. Maecenas sit amet justo facilisis, porttitor ex et, eleifend sem.")
        val fan2 = FactAboutNumber(1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam rutrum eros massa, sit amet cursus odio rutrum quis. Ut blandit maximus massa in iaculis. Suspendisse eget est massa. Ut a gravida lorem, quis eleifend justo. Proin maximus tortor in odio pellentesque, eu commodo nibh condimentum. Etiam eget mauris at sem tincidunt hendrerit. Donec ut vulputate eros, interdum tempor nisl.")
        adapter = FactItemAdapter(listOf(fan1, fan2))
        binding.recyclerView.adapter = adapter

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}