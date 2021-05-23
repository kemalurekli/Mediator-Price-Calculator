package com.kemalurekli.pricecalculator.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kemalurekli.pricecalculator.R
import com.kemalurekli.pricecalculator.databinding.FragmentFirstPartBinding
import com.kemalurekli.pricecalculator.viewmodel.FirstPartFragmentViewModel


class FirstPartFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private var _binding: FragmentFirstPartBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel : FirstPartFragmentViewModel
    private var select1 : Int? = null


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
        observeLiveData()
        //For Spinner
        val spinner: Spinner = binding.firstSpinner
        val spinner2 : Spinner = binding.secondSpinner
        spinner.onItemSelectedListener = this
        spinner2.onItemSelectedListener = this

        ArrayAdapter.createFromResource(requireContext(), R.array.planets_array, android.R.layout.simple_spinner_item).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
        ArrayAdapter.createFromResource(requireContext(), R.array.months_array, android.R.layout.simple_spinner_item).also { adapter2 ->
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner2.adapter = adapter2
        }


    }
    private fun observeLiveData() {

        viewModel.getParameters.observe(viewLifecycleOwner, Observer {getParameters ->
            getParameters?.let {
                val dataone = getParameters[0].firstPartData1
            }
        })
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        select1 = position
        println(select1)
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}