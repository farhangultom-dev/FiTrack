package com.farhandev.financialtracking.ui.onboarding

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.farhandev.financialtracking.R

class OnboardingAdapter(var list: List<Int>,var listText: List<String>, var ctx: Context): PagerAdapter() {

    lateinit var layoutInflater: LayoutInflater

    override fun getCount(): Int = list.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean = view == `object`

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = LayoutInflater.from(ctx)
        var view = layoutInflater.inflate(R.layout.item_onboarding, container, false)
        val img = view.findViewById<ImageView>(R.id.ivOnboarding)
        val txt = view.findViewById<TextView>(R.id.tvContent)

        img.setImageResource(list[position])
        txt.text = listText[position]

        container.addView(view,0)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}