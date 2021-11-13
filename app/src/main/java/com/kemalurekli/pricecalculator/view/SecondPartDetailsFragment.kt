package com.kemalurekli.pricecalculator.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kemalurekli.pricecalculator.databinding.FragmentSecondPartDetailsBinding
import com.kemalurekli.pricecalculator.viewmodel.SecondPartDetailsFragmentViewModel


class SecondPartDetailsFragment : Fragment() {
    private var _binding: FragmentSecondPartDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel : SecondPartDetailsFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondPartDetailsBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[SecondPartDetailsFragmentViewModel::class.java]
        arguments?.let {
            val userInputPrice = SecondPartDetailsFragmentArgs.fromBundle(it).userInputA
            val select1 = SecondPartDetailsFragmentArgs.fromBundle(it).select1A
            val select2 = SecondPartDetailsFragmentArgs.fromBundle(it).select2A
            val select3 = SecondPartDetailsFragmentArgs.fromBundle(it).select3A
            val select4 = SecondPartDetailsFragmentArgs.fromBundle(it).select4A


            //Mediator Ratio
            if (select1==1){
                binding.row1ratio.text = "%9"
                binding.row2ratio.text = "%7.5"
                binding.row3ratio.text = "%6"
                binding.row4ratio.text = "%4.5"
                binding.row5ratio.text = "%3"
                binding.row6ratio.text = "%2.5"
                binding.row7ratio.text = "%1.5"
                binding.row8ratio.text = "%1"
            }

            binding.calButton.setOnClickListener {
                viewModel.getDataFromSecondAndCalculate(userInputPrice.toDouble(),select1,select2,select3,select4)
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}