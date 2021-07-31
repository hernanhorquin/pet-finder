package com.example.petfinder.ui.adoption

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.petfinder.data.model.Pet
import com.example.petfinder.databinding.FragmentAdoptionBinding
import com.example.petfinder.ui.PublishPetActivity
import com.example.petfinder.ui.adapter.PetAdapter
import com.example.petfinder.ui.filter.FilterActivity
import com.example.petfinder.utils.CustomFilterButtons
import com.example.petfinder.utils.NavigationHelper

class AdoptionFragment : Fragment() {

    private lateinit var adoptionViewModel: AdoptionViewModel
    private lateinit var binding: FragmentAdoptionBinding

    var recyclerViewAdapter: PetAdapter = PetAdapter() {
        NavigationHelper().goToDetailActivity(requireActivity(), it)
    }

    var listaDelBackend = listOf(
        Pet("1", "1", "Pancho", null, null, null, null, null, null, null, null, null, "c"),
        Pet("1", "1", "Juancho", null, null, null, null, null, null, null, null, null, "d"),
        Pet("1", "1", "Chacho", null, null, null, null, null, null, null, null, null, "c")
    )


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

        binding.publishPet.setOnClickListener {
            startActivity(Intent(context, PublishPetActivity::class.java))
        }

        binding.filterBtn.setOnClickListener {
            startActivity(Intent(context, FilterActivity::class.java))
        }

        return binding.root
    }

    private fun initRecyclerView() {
        recyclerViewAdapter.update(listaDelBackend)
        binding.adoptionPetRecycler.apply {
            adapter = recyclerViewAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    val listener: CustomFilterButtons.FilterButtonsHandler =
        object : CustomFilterButtons.FilterButtonsHandler {
            override fun setOnAllPetsClickListener() {
                resetFilter()
                binding.filterLinear.updateUI("ALL")
            }

            override fun setOnDogsClickListener() {

                if (binding.filterLinear.actualSelected == "d") {
                    resetFilter()
                    binding.filterLinear.actualSelected = "a"
                } else
                    binding.adoptionPetRecycler.apply {
                        recyclerViewAdapter.update(listaDelBackend.filter {
                            it.catOrDog == "d"
                        })
                        adapter = recyclerViewAdapter
                    }
                binding.filterLinear.updateUI("DOGS")

            }

            override fun setOnCatsClickListener() {
                if (binding.filterLinear.actualSelected == "c") {
                    resetFilter()
                    binding.filterLinear.actualSelected = "a"
                } else
                    binding.adoptionPetRecycler.apply {
                        recyclerViewAdapter.update(listaDelBackend.filter {
                            it.catOrDog == "c"
                        })
                        adapter = recyclerViewAdapter
                    }
                binding.filterLinear.updateUI("CATS")

            }
        }

    private fun resetFilter() {
        binding.adoptionPetRecycler.apply {
            recyclerViewAdapter.update(listaDelBackend.filter {
                it.catOrDog == "c" || it.catOrDog == "d"
            })
            adapter = recyclerViewAdapter
        }
    }
}