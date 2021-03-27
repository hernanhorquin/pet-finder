package com.example.petfinder.ui.home.tabFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.petfinder.data.model.Pet
import com.example.petfinder.databinding.FragmentLostPetsBinding
import com.example.petfinder.ui.adapter.PetAdapter
import com.example.petfinder.utils.CustomFilterButtons
import com.example.petfinder.utils.NavigationHelper

class LostPetsFragment : Fragment(){

    private lateinit var binding: FragmentLostPetsBinding

    val listener: CustomFilterButtons.FilterButtonsHandler = object : CustomFilterButtons.FilterButtonsHandler {
        override fun setOnAllPetsClickListener() {
            binding.filterLinear.updateUI("ALL")
        }

        override fun setOnDogsClickListener() {
            binding.filterLinear.updateUI("DOGS")
        }

        override fun setOnCatsClickListener() {
            binding.filterLinear.updateUI("CATS")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = FragmentLostPetsBinding.inflate(layoutInflater)
        binding.filterLinear.setEventHandler(listener)
        binding.apply {
            initRecyclerView()
        }
        return binding.root
    }


    private fun initRecyclerView() {
        val recyclerViewAdapter = PetAdapter(
            listOf(
                Pet("1", "1", "Pancho", null, null, null, null, null, null, null, null, null),
                Pet("1", "1", "Juancho", null, null, null, null, null, null, null, null, null),
                Pet("1", "1", "Chacho", null, null, null, null, null, null, null, null, null)
            )
        ) {
            NavigationHelper().goToDetailActivity(requireActivity(), it)
        }
        binding.petRecycler.apply {
            adapter = recyclerViewAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() =
                LostPetsFragment().apply {
                    arguments = Bundle().apply {
                    }
                }
    }

}