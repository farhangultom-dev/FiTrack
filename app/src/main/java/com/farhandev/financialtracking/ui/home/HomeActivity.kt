package com.farhandev.financialtracking.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.farhandev.financialtracking.R
import com.farhandev.financialtracking.databinding.ActivityHomeBinding
import com.farhandev.financialtracking.localdatabase.FinancialTracking

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var adapter: FinancialTrackingAdapter
    private var listItem: ArrayList<FinancialTracking> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = FinancialTrackingAdapter(arrayListOf())

        initData()

        with(binding){
            rvTracking.adapter = adapter
            rvTracking.setHasFixedSize(true)
        }
    }

    private fun initData() {
        listItem = ArrayList()
        listItem.add(FinancialTracking(1,10000,"telor setengah kilo","23-01-2022"))
        listItem.add(FinancialTracking(2,15000,"makan siang","23-01-2022"))
        listItem.add(FinancialTracking(1,5000,"Kopi","23-01-2022"))
        adapter.setListItem(listItem)
    }
}