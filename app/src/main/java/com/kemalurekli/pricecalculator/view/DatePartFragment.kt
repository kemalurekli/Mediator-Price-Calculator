package com.kemalurekli.pricecalculator.view

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.kemalurekli.pricecalculator.databinding.FragmentDatePartBinding
import java.util.*
import java.util.Calendar.DAY_OF_MONTH


class DatePartFragment : Fragment() {

    private var _binding: FragmentDatePartBinding? = null
    private val binding get() = _binding!!
    lateinit var mAdView : AdView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDatePartBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //For Ads
        MobileAds.initialize(requireContext()) {}
        mAdView = binding.adView
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        val mPickTimeBtn = binding.pickDateBtn
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        var day = c.get(DAY_OF_MONTH)

        binding.llTable.visibility = View.INVISIBLE




        mPickTimeBtn.setOnClickListener {

            val dpd = DatePickerDialog(requireContext(), { view, year, monthOfYear, dayOfMonth ->
                // Display Selected date in TextView
                binding.llTable.visibility = View.VISIBLE

                val newC = Calendar.getInstance()
                newC.set(year,monthOfYear,dayOfMonth)
                binding.tvAcceptDate.text = "Arabuluculuk Görevinin Kabul Edildiği Tarih: ${newC[5]}/${newC[2]+1}/${newC[1]}"
                newC.add(5,21)
                binding.tvis3.text = "${newC[5]}/${newC[2]+1}/${newC[1]}"
                binding.tvtu3.text = "${newC[5]}/${newC[2]+1}/${newC[1]}"
                newC.add(5,7)
                binding.tvis4.text = "${newC[5]}/${newC[2]+1}/${newC[1]}"
                binding.tvtu4.text = "${newC[5]}/${newC[2]+1}/${newC[1]}"
                newC.add(5,14)
                binding.tvti6.text = "${newC[5]}/${newC[2]+1}/${newC[1]}"
                newC.add(5,14)
                binding.tvti8.text = "${newC[5]}/${newC[2]+1}/${newC[1]}"
            }, year, month, day)
            dpd.show()

        }




    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}