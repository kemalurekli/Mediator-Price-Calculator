package com.kemalurekli.pricecalculator.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.kemalurekli.pricecalculator.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.goToFirstPartButton.setOnClickListener {
            Navigation.findNavController(it).navigate(HomeFragmentDirections.actionHomeFragmentToFirstPartFragment())
        }
        binding.goToSecondPartButton.setOnClickListener {
            Navigation.findNavController(it).navigate(HomeFragmentDirections.actionHomeFragmentToSecondOptionFragment())
        }
        binding.goToDatePartButton.setOnClickListener {
            Navigation.findNavController(it).navigate(HomeFragmentDirections.actionHomeFragmentToDatePartFragment())
        }
        binding.goToApp.setOnClickListener {
            Navigation.findNavController(it).navigate(HomeFragmentDirections.actionHomeFragmentToAboutFragment())
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}