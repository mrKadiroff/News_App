package com.example.news_app.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.news_app.bottom_fragments.GlavniFragment

class ViewPagerAdapter(
    var list: Array<String>,
    fragmentManager: FragmentManager, lifecycle: Lifecycle
) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun createFragment(position: Int): Fragment {
        return GlavniFragment.newInstance(position,"fuck")
    }
}