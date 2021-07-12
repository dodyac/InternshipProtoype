package com.acxdev.internship

import android.content.Intent
import com.acxdev.commonFunction.adapter.BaseAdapter
import com.acxdev.internship.databinding.RowActivelyHiringBinding
import com.google.gson.Gson

class RowActivelyHiring(private val list: MutableList<Job>): BaseAdapter<RowActivelyHiringBinding>(RowActivelyHiringBinding::inflate, list) {
    override fun onBindViewHolder(holder: ViewHolder<RowActivelyHiringBinding>, position: Int) {
        val list = list[position]
        holder.binding.image.setImageResource(list.image)
        holder.binding.applicants.text = "${list.applicants} Applicants"
        holder.binding.location.text = list.location
        holder.binding.time.text = list.duration
        holder.binding.title.text = list.title
        holder.binding.company.text = list.company
        holder.itemView.setOnClickListener { context.startActivity(Intent(context, ActivityDetail::class.java).putExtra(Constant.DATA, Gson().toJson(list))) }
    }
}