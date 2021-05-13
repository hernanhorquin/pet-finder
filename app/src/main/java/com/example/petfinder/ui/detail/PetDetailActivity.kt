package com.example.petfinder.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.petfinder.R
import com.example.petfinder.data.model.Pet
import com.example.petfinder.databinding.ActivityPetDetailBinding
import com.example.petfinder.ui.adapter.PetAdapter
import com.example.petfinder.ui.adapter.PetImageAdapter
import com.example.petfinder.utils.NavigationHelper
import org.imaginativeworld.whynotimagecarousel.CarouselItem
import org.imaginativeworld.whynotimagecarousel.ImageCarousel

class PetDetailActivity : AppCompatActivity() {

    companion object {
        const val PET = "pet"
    }

    val list = mutableListOf<CarouselItem>()

// Image URL with caption



    private lateinit var binding: ActivityPetDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        binding = ActivityPetDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backButton.setOnClickListener {
            onBackPressed()
        }

        val recyclerViewAdapter = PetImageAdapter(
            listOf(
                "asd",
                "asd",
                "asd"
            )
        )

        list.add(
            CarouselItem(
                imageUrl = "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080"
            )
        )
        list.add(
            CarouselItem(
                imageUrl = "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080"
            )
        )
        list.add(
            CarouselItem(
                imageUrl = "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080"
            )
        )
        binding.petImageList.addData(list)
//        binding.petImageList.apply {
//            adapter = recyclerViewAdapter
//            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
//        }
    }
}