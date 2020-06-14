package com.example.basemvvmexample.ui.view.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.basemvvmexample.R
import com.example.basemvvmexample.databinding.MainActivityBinding
import com.example.basemvvmexample.ui.viewmodel.SharedViewModel
import kotlinx.android.synthetic.main.main_activity.bottomNavigation
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val sharedViewModel by viewModel<SharedViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bottomNavigation.setupWithNavController(findNavController(R.id.mainNavigationFragment))
        findNavController(R.id.mainNavigationFragment).addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.subBreedFragment, R.id.breedFragment, R.id.dogGalleryFragment -> showBottomNavigation()
                else -> hideBottomNavigation()
            }
        }
    }

        private fun showBottomNavigation() {
            with(bottomNavigation) {
                animate()
                        .alpha(1f)
                        .withEndAction { visibility = View.VISIBLE }
                        .duration = BOTTOM_BAR_ENTER_DURATION
            }
        }

        fun hideBottomNavigation() {
            with(bottomNavigation) {
                if (visibility == View.VISIBLE && alpha == 1f) {
                    animate()
                            .alpha(0f)
                            .withEndAction { visibility = View.GONE }
                            .duration = BOTTOM_BAR_EXIT_DURATION
                }
            }
        }

    companion object {
        const val BOTTOM_BAR_ENTER_DURATION = 200L
        const val BOTTOM_BAR_EXIT_DURATION = 200L
    }
}
