package com.example.petfinder.ui.home.tabFragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.petfinder.ui.home.tabFragments.FoundPetsFragment
import com.example.petfinder.ui.home.tabFragments.LostPetsFragment


class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    val fragmentList = listOf(LostPetsFragment.newInstance(), FoundPetsFragment.newInstance())

    override fun getCount(): Int  = 2

    override fun getItem(i: Int): Fragment = fragmentList[i]

    override fun getPageTitle(position: Int): CharSequence {
        return when(position) {
            0 -> "Perdidos"
            else -> "Encontrados"
        }
    }

}