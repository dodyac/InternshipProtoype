package com.acxdev.internship

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.acxdev.commonFunction.util.view.RecyclerViewX.Companion.adapter
import com.acxdev.internship.databinding.FragmentHomeBinding

class FragmentHome : Fragment() {


    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mutableList = mutableListOf<Job>()
        mutableList.add(Job(R.drawable.netflix, "UX Writter Intern", "Netflix", "Bandung", "6 Months", 189, R.array.requirement_gojek, R.array.benefit_gojek))
        mutableList.add(Job(R.drawable.gojek, "UI Designer Intern", "Gojek", "Jakarta", "3 Months", 112, R.array.requirement_gojek, R.array.benefit_gojek))

        val mutableListSlack = mutableListOf<Job>()
        mutableListSlack.add(Job(R.drawable.slack, "Product Manager Intern", "Slack", "Silicon Valley", "6 Months", 112, R.array.requirement_gojek, R.array.benefit_gojek))
        mutableListSlack.add(Job(R.drawable.ic_microsoft, "Research Intern - Social Media Collective", "Microsoft", "Cambridge, MA", "6 Months", 700, R.array.requirement_microsoft, R.array.benefit_microsoft))

        binding.activelyHiring.adapter(RowActivelyHiring(mutableList), true)
        binding.newInternship.adapter(RowNewInternship(mutableListSlack),1)

    }

}