package com.kemalurekli.pricecalculator.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.kemalurekli.pricecalculator.R
import com.kemalurekli.pricecalculator.databinding.FragmentSecondPartBinding
import java.util.*


class SecondPartFragment : Fragment() {

    private var _binding: FragmentSecondPartBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondPartBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val firstInput : Spinner = binding.firstSpinner
        val secondInput : Spinner = binding.secondSpinner
        val thirdInput : Spinner = binding.thirdSpinner
        val fourthInput : Spinner = binding.fourthSpinner

        binding.calculateButton.visibility = View.INVISIBLE

        //Spinner Adapters
        ArrayAdapter.createFromResource(requireContext(), R.array.second_part_first_spinner, android.R.layout.simple_spinner_item).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            firstInput.adapter = adapter
        }
        ArrayAdapter.createFromResource(requireContext(), R.array.second_part_second_spinner, android.R.layout.simple_spinner_item).also { adapter2 ->
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            secondInput.adapter = adapter2
        }
        ArrayAdapter.createFromResource(requireContext(), R.array.second_part_third_spinner, android.R.layout.simple_spinner_item).also { adapter3 ->
            adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            thirdInput.adapter = adapter3
        }
        ArrayAdapter.createFromResource(requireContext(), R.array.second_part_fourth_spinner, android.R.layout.simple_spinner_item).also { adapter4 ->
            adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            fourthInput.adapter = adapter4
        }

        binding.userInputCost.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (binding.userInputCost.text.toString() == "" || binding.userInputCost.text.toString() ==".") {
                    binding.userInputCost.text.clear()
                    binding.calculateButton.visibility = View.INVISIBLE
                }else{
                    binding.calculateButton.visibility = View.VISIBLE
                }
            }

        })

        binding.calculateButton.setOnClickListener {
            // viewModel.calculateSecondPartPrice(userInput.toString().toDouble(),firstInput.selectedItemPosition, secondInput.selectedItemPosition, thirdInput.selectedItemPosition, fourthInput.selectedItemPosition)

            Navigation.findNavController(it).navigate(SecondPartFragmentDirections.actionSecondPartFragmentToSecondPartDetailsFragment(binding.userInputCost.text.toString(),firstInput.selectedItemPosition, secondInput.selectedItemPosition, thirdInput.selectedItemPosition, fourthInput.selectedItemPosition))


        }




    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}