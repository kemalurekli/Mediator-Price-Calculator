package com.kemalurekli.pricecalculator.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kemalurekli.pricecalculator.R
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
            SetView(select1,userInputPrice.toDouble(),select2,select3,select4)



        }


    }
    private fun SetView(selection : Int, userInput : Double, selection2 : Int, selection3: Int, selection4: Int){
        binding.tv50.text=viewModel.calculate50(userInput,selection,selection4).toString()
        binding.tv80.text=viewModel.calculate80(userInput,selection,selection4).toString()
        binding.tv130.text=viewModel.calculate130(userInput,selection,selection4).toString()
        binding.tv260.text=viewModel.calculate260(userInput,selection,selection4).toString()
        binding.tv780.text=viewModel.calculate780(userInput,selection,selection4).toString()
        binding.tv1040.text=viewModel.calculate1040(userInput,selection,selection4).toString()
        binding.tv2080.text=viewModel.calculate2080(userInput,selection,selection4).toString()
        binding.tv4160.text=viewModel.calculate4160(userInput,selection,selection4).toString()
        binding.tvtotal.text=viewModel.calculateTotal(userInput)
        binding.tvtotal.text = "$userInput tl "
        if (selection==1){
            binding.row1ratio.text = "%9"
            binding.row2ratio.text = "%7.5"
            binding.row3ratio.text = "%6"
            binding.row4ratio.text = "%4.5"
            binding.row5ratio.text = "%3"
            binding.row6ratio.text = "%2.5"
            binding.row7ratio.text = "%1.5"
            binding.row8ratio.text = "%1"
    }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}