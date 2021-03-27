package com.example.petfinder.ui.adoption

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.petfinder.data.model.Pet
import com.example.petfinder.databinding.FragmentAdoptionBinding
import com.example.petfinder.ui.adapter.PetAdapter
import com.example.petfinder.utils.CustomFilterButtons
import com.example.petfinder.utils.NavigationHelper

class AdoptionFragment : Fragment() {

    private lateinit var adoptionViewModel: AdoptionViewModel
    private lateinit var binding: FragmentAdoptionBinding

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

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        adoptionViewModel = ViewModelProvider(this).get(AdoptionViewModel::class.java)
        binding = FragmentAdoptionBinding.inflate(layoutInflater)
        binding.filterLinear.setEventHandler(listener)

        binding.apply {
            activity?.actionBar?.title = Html.fromHtml("<font color='#43CBDB'>Pet Finder </font>")
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
        binding.adoptionPetRecycler.apply {
            adapter = recyclerViewAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }
}