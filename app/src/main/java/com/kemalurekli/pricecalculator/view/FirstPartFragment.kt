package com.kemalurekli.pricecalculator.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.kemalurekli.pricecalculator.databinding.FragmentFirstPartBinding
import com.kemalurekli.pricecalculator.viewmodel.FirstPartFragmentViewModel


class FirstPartFragment : Fragment() {

    private var _binding: FragmentFirstPartBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel : FirstPartFragmentViewModel


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




    }

    private fun observeLiveData() {

        viewModel.getParameters.observe(viewLifecycleOwner, Observer {getParameters ->
            getParameters?.let {
                val dataone = getParameters[0].firstPartData1
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}