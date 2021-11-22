package com.kemalurekli.pricecalculator.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.kemalurekli.pricecalculator.R
import com.kemalurekli.pricecalculator.databinding.FragmentSecondOptionBinding
import com.kemalurekli.pricecalculator.databinding.FragmentSecondPartBinding

class SecondOptionFragment : Fragment() {

    private var _binding: FragmentSecondOptionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondOptionBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnDavaSarti.setOnClickListener {
            Navigation.findNavController(it).navigate(SecondOptionFragmentDirections.actionSecondOptionFragmentToSecondPartFragment())
        }
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}