package com.acxdev.internship

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.acxdev.commonFunction.util.view.OtherViewX.Companion.html
import com.acxdev.internship.databinding.FragmentOnBoardingBinding

class FragmentOnBoarding : Fragment() {


    private lateinit var binding: FragmentOnBoardingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardingBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val string = "<font color=#304675>Find</font> <font color=#0DAB4E>Dream <br>Internship</font> <font color=#304675>Program</font>"
        binding.title.html(string)
    }


}