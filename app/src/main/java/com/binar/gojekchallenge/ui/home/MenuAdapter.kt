package com.binar.gojekchallenge.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.binar.gojekchallenge.databinding.ItemMenuBinding
import com.binar.gojekchallenge.model.Menu

class MenuAdapter(private var onItemClick: (Menu) -> Unit) : BaseAdapter() {
    private var listData = ArrayList<Menu>()
    fun setData(newListData: List<Menu>) {
        listData.addAll(newListData)
    }

    override fun getCount(): Int = listData.size

    override fun getItem(position: Int): Any {
        return listData[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val holder: ViewHolder
        val data = listData[position]

        if (convertView == null) {
            val itemBinding = ItemMenuBinding.inflate(
                LayoutInflater.from(parent?.context), parent, false)
            holder = ViewHolder(itemBinding)
            holder.view = itemBinding.root
            holder.view.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
        }

        with(holder.binding) {
            itemImg.setImageResource(data.image)
            itemName.text = data.name
            itemName.textSize = 12f
            root.setOnClickListener {
                onItemClick(data)
            }
        }

        return holder.view
    }
    inner class ViewHolder(binding: ItemMenuBinding) {
        var view: View = binding.root
        val binding: ItemMenuBinding = binding

    }
}