package com.kemalurekli.pricecalculator.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.core.view.get
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kemalurekli.pricecalculator.R
import com.kemalurekli.pricecalculator.databinding.FragmentFirstPartBinding
import com.kemalurekli.pricecalculator.viewmodel.FirstPartFragmentViewModel


class FirstPartFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private var _binding: FragmentFirstPartBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel : FirstPartFragmentViewModel

    private var userInputTime: Int = 3
    private var spinner1Position : Int = 0
    private var spinner2Position : Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstPartBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[FirstPartFragmentViewModel::class.java]
        viewModel.getParameters()


        //For Spinner
        val spinner: Spinner = binding.firstSpinner
        val spinner2 : Spinner = binding.secondSpinner
        spinner.onItemSelectedListener = this
        spinner2.onItemSelectedListener = this

        //Spinner Adapters
        ArrayAdapter.createFromResource(requireContext(), R.array.first_part_first_spinner, android.R.layout.simple_spinner_item).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
        ArrayAdapter.createFromResource(requireContext(), R.array.first_part_second_spinner, android.R.layout.simple_spinner_item).also { adapter2 ->
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner2.adapter = adapter2
        }



        binding.hesapla.setOnClickListener {
            //get User Input Data
            userInputTime = binding.userInputTime.text.toString().toInt()
            spinner1Position = spinner.selectedItemPosition
            spinner2Position = spinner2.selectedItemPosition
            //Calculate with a function from viewmodel.
            var result = viewModel.CalculateFirstPart(userInputTime,spinner1Position,spinner2Position)
            binding.tvFirstPartExp.text = "${spinner.selectedItem.toString()} ${spinner2.selectedItem.toString()} Hesaplanan Değer : $result'dır. "
        }



    }









    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        //userInput1 = position

            //println(parent!!.adapter.)





    }

    override fun onNothingSelected(parent: AdapterView<*>?) {

    }











    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}