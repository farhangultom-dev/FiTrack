package com.farhandev.financialtracking.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.farhandev.financialtracking.databinding.ItemTrackingBinding
import com.farhandev.financialtracking.localdatabase.FinancialTracking

class FinancialTrackingAdapter(val listItem: ArrayList<FinancialTracking>) : RecyclerView.Adapter<FinancialTrackingAdapter.ViewHolder>(){

    fun setListItem(item: List<FinancialTracking>){
        listItem.clear()
        listItem.addAll(item)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FinancialTrackingAdapter.ViewHolder {
        val binding = ItemTrackingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FinancialTrackingAdapter.ViewHolder, position: Int) {
        holder.bind(listItem[position])
    }

    override fun getItemCount(): Int = listItem.size

    inner class ViewHolder(val binding: ItemTrackingBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: FinancialTracking){
            binding.tvPrice.text = item.spendingValue.toString()
            binding.tvTanggal.text = item.date
            binding.tvDetail.text = item.desc
        }
    }
}