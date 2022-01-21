package com.farhandev.financialtracking.ui.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.farhandev.financialtracking.R
import com.farhandev.financialtracking.databinding.ActivityOnboardingBinding
import com.farhandev.financialtracking.sharedpreferences.PrefManager
import com.farhandev.financialtracking.ui.inputprofile.InputProfileActivity
import java.util.*

class OnboardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnboardingBinding
    private lateinit var pref: PrefManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        pref = PrefManager(this)
        setContentView(binding.root)

        val imgs = listOf(R.drawable.ic_slide_1,R.drawable.ic_slide_2,R.drawable.ic_slide_3)
        val txt = listOf("Catat semua pengeluaran dan pemasukanmu",
            "Lacak semua pengeluaran agar tidak ada pengeluaran yang tidak berguna",
        "Kamu akan diberitahu kalau batas anggaranmu sudah tercapai")

        val adapter = OnboardingAdapter(imgs, txt, this)

        with(binding){

            viewPager.adapter = adapter
            viewPager.autoScroll(4000)

            btnClose.setOnClickListener{
                onBackPressed()
            }
            btnStart.setOnClickListener {
                pref.put("offOnBoarding",0)
                startActivity(Intent(this@OnboardingActivity, InputProfileActivity::class.java))
            }
        }
    }

    private fun ViewPager.autoScroll(interval: Long){
        val handler = Handler()
        var scrollPosition = 0

        val runnable = object : Runnable {

            override fun run() {

                /**
                 * Calculate "scroll position" with
                 * adapter pages count and current
                 * value of scrollPosition.
                 */
                val count = adapter?.count ?: 0
                setCurrentItem(scrollPosition++ % count, true)

                handler.postDelayed(this, interval)
            }
        }

        addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
            override fun onPageSelected(position: Int) {
                // Updating "scroll position" when user scrolls manually
                scrollPosition = position + 1
            }

            override fun onPageScrollStateChanged(state: Int) {
                // Not necessary
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                // Not necessary
            }
        })

        handler.post(runnable)
    }
}