package com.acxdev.internship

import android.content.Intent
import com.acxdev.commonFunction.adapter.BaseAdapter
import com.acxdev.internship.databinding.RowActivelyHiringBinding
import com.acxdev.internship.databinding.RowNewInternshipBinding
import com.google.gson.Gson

class RowNewInternship(private val list: MutableList<Job>): BaseAdapter<RowNewInternshipBinding>(RowNewInternshipBinding::inflate, list) {
    override fun onBindViewHolder(holder: ViewHolder<RowNewInternshipBinding>, position: Int) {
        val list = list[position]
        holder.binding.image.setImageResource(list.image)
        holder.binding.location.text = list.location
        holder.binding.title.text = list.title
        holder.binding.company.text = list.company
        holder.itemView.setOnClickListener { context.startActivity(Intent(context, ActivityDetail::class.java).putExtra(Constant.DATA, Gson().toJson(list))) }
    }
}