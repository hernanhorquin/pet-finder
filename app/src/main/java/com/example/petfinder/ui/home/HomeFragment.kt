package com.example.petfinder.ui.home

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.petfinder.databinding.FragmentHomeBinding
import com.example.petfinder.ui.home.tabFragments.ViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewPagerAdapter: ViewPagerAdapter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        binding = FragmentHomeBinding.inflate(layoutInflater)

        binding.apply {

            tabLayout.setupWithViewPager(viewPager)
            viewPagerAdapter =
                ViewPagerAdapter(
                    childFragmentManager
                )
            viewPager.adapter = viewPagerAdapter
            activity?.actionBar?.title = Html.fromHtml("<font color='#43CBDB'>Pet Finder </font>")

        }

        return binding.root
    }
}