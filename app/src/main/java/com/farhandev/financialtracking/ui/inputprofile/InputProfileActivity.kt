package com.farhandev.financialtracking.ui.inputprofile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.farhandev.financialtracking.R
import com.farhandev.financialtracking.databinding.ActivityInputProfileBinding
import com.farhandev.financialtracking.ui.home.HomeActivity
import com.farhandev.financialtracking.ui.inputsalary.InputSalaryActivity

class InputProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInputProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            ivBack.setOnClickListener { onBackPressed() }

            btnNext.setOnClickListener { startActivity(Intent(this@InputProfileActivity, InputSalaryActivity::class.java)) }
        }
    }
}