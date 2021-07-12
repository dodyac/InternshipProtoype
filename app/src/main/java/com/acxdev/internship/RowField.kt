package com.acxdev.internship

import com.acxdev.commonFunction.adapter.BaseAdapter
import com.acxdev.internship.databinding.RowFieldBinding

class RowField(private val list: MutableList<String>): BaseAdapter<RowFieldBinding>(RowFieldBinding::inflate, list) {
    override fun onBindViewHolder(holder: ViewHolder<RowFieldBinding>, position: Int) {
        val list= list[position]
        holder.binding.field.text = list
    }
}