package com.farhandev.financialtracking.ui.splashactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.farhandev.financialtracking.R
import com.farhandev.financialtracking.databinding.ActivitySplashBinding
import com.farhandev.financialtracking.sharedpreferences.PrefManager
import com.farhandev.financialtracking.ui.home.HomeActivity
import com.farhandev.financialtracking.ui.onboarding.OnboardingActivity

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private lateinit var pref: PrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        pref = PrefManager(this)
        setContentView(binding.root)

        val handler = Handler(mainLooper)

        handler.postDelayed({
            if (pref.getInt("offOnBoarding") == 0){
                startActivity(Intent(this, OnboardingActivity::class.java))
                finish()
            }else{
                startActivity(Intent(this, HomeActivity::class.java))
                finish()
            }
        }, 2000)
    }
}