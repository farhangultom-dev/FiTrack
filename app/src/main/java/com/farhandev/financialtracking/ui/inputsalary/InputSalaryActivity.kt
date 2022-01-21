package com.farhandev.financialtracking.ui.inputsalary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.farhandev.financialtracking.R
import com.farhandev.financialtracking.databinding.ActivityInputSalaryBinding
import com.farhandev.financialtracking.ui.home.HomeActivity

class InputSalaryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInputSalaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputSalaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            btnDone.setOnClickListener {
                startActivity(Intent(this@InputSalaryActivity, HomeActivity::class.java))
                finish()
            }
        }
    }
}