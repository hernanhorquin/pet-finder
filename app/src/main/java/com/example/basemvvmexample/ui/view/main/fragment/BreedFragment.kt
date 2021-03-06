package com.example.basemvvmexample.ui.view.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basemvvmexample.R
import com.example.basemvvmexample.data.api.response.DogBreedResponse
import com.example.basemvvmexample.data.api.response.Resource
import com.example.basemvvmexample.data.api.response.Status
import com.example.basemvvmexample.databinding.BreedFragmentBinding
import com.example.basemvvmexample.ui.adapter.PetAdapter
import com.example.basemvvmexample.ui.viewmodel.BreedViewModel
import com.example.basemvvmexample.ui.viewmodel.SharedViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import retrofit2.Response

class BreedFragment : Fragment() {

    private val viewModel by viewModel<BreedViewModel>()
    private val sharedViewModel by sharedViewModel<SharedViewModel>()
    private lateinit var binding: BreedFragmentBinding
    private lateinit var getDogBreedsObserverResponse: Observer<Resource<Response<DogBreedResponse>>>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = BreedFragmentBinding.inflate(inflater, container, false).apply {
            breedViewModel = this@BreedFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
            holder = this@BreedFragment
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        setUpObservers()
    }
    override fun onStart() {
        super.onStart()
        setUpObservers()
//        binding.breedFragmentSearch.setOnClickListener {
//            binding.breedViewModel?.getDogBreedsFromRepo()?.observe(viewLifecycleOwner, getDogBreedsObserverResponse)
//        }
    }

    private fun initRecyclerView() {
        val recyclerViewAdapter = PetAdapter(listOf("Ejemplo 1", "Ejemplo 2", "Ejemplo 3", "Ejemplo 4"), sharedViewModel)
        binding.breedFragmentRecyclerView.apply {
            adapter = recyclerViewAdapter
            layoutManager = LinearLayoutManager(context)
        }
        binding.breedViewModel?.dogBreedsLiveData?.observe(viewLifecycleOwner, Observer { breeds ->
            breeds?.let {  }
        })
    }

    private fun setUpObservers() {
        getDogBreedsObserverResponse = Observer<Resource<Response<DogBreedResponse>>> {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        hideLoading()
                    }
                    Status.ERROR -> {
                        hideLoading()
                    }
                    Status.LOADING -> {
                        showLoading()
                    }
                }
            }
        }
    }

    private fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
        binding.breedFragmentRecyclerView.visibility = View.INVISIBLE
    }

    private fun hideLoading() {
        binding.progressBar.visibility = View.INVISIBLE
        binding.breedFragmentRecyclerView.visibility = View.VISIBLE
    }

    fun execAction() = NavHostFragment.findNavController(this).navigate(R.id.action_breedFragment_to_subBreedFragment)
}
