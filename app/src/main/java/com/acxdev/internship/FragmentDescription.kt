package com.acxdev.internship

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.acxdev.commonFunction.util.view.RecyclerViewX.Companion.adapter
import com.acxdev.internship.databinding.FragmentDescriptionBinding
import com.google.gson.Gson


class FragmentDescription : Fragment() {

    private lateinit var binding: FragmentDescriptionBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDescriptionBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = Gson().fromJson(arguments?.getString(Constant.DATA), Job::class.java)
        binding.requirement.adapter(RowField(resources.getStringArray(data.description).toMutableList()),1)
        binding.benefit.adapter(RowField(resources.getStringArray(data.benefit).toMutableList()),1)
    }

}