package com.example.petfinder.utils

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.petfinder.R

class CustomFilterButtons(context: Context?, attributes: AttributeSet? = null) : LinearLayout(context, attributes) {

    private lateinit var allPetsBtn: CardView
    private lateinit var dogsBtn: CardView
    private lateinit var catsBtn: CardView

    private var isAllPetsBtnSelected = false
    private var isDogsBtnSelected = false
    private var isCatsBtnSelected = false


    private var listener: FilterButtonsHandler? = null

    init {
        initControls(context)
        listener = context as? FilterButtonsHandler

    }

    private fun initControls(context: Context?) {
        val inflater: LayoutInflater =
            context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        inflater.inflate(R.layout.button_filter, this)

        allPetsBtn = findViewById(R.id.all_pets_btn)
        dogsBtn = findViewById(R.id.dog_btn)
        catsBtn = findViewById(R.id.cat_btn)
        setListeners()
    }

    private fun setListeners() {
        allPetsBtn.setOnClickListener {
            listener?.setOnAllPetsClickListener()
        }

        dogsBtn.setOnClickListener {
            listener?.setOnDogsClickListener()
        }

        catsBtn.setOnClickListener {
            listener?.setOnCatsClickListener()
        }
    }

    fun setEventHandler(handler: FilterButtonsHandler) {
        this.listener = handler
    }

    fun updateUI(selected: String) {
        when(selected) {
            "ALL" -> {
                if (!isAllPetsBtnSelected) {
                    isAllPetsBtnSelected = true
                    allPetsBtn.setCardBackgroundColor(ContextCompat.getColor(context, R.color.tab_background_selected))
                }
                else {
                    isAllPetsBtnSelected = false
                    allPetsBtn.setCardBackgroundColor(ContextCompat.getColor(context, R.color.filter_btn_background))
                }
            }
            "DOGS" -> {
                if (!isDogsBtnSelected) {
                    isDogsBtnSelected = true
                    dogsBtn.setCardBackgroundColor(ContextCompat.getColor(context, R.color.tab_background_selected))
                }
                else {
                    isDogsBtnSelected = false
                    dogsBtn.setCardBackgroundColor(ContextCompat.getColor(context, R.color.filter_btn_background))
                }
            }
            "CATS" -> {
                if (!isCatsBtnSelected){
                    isCatsBtnSelected = true
                    catsBtn.setCardBackgroundColor(ContextCompat.getColor(context, R.color.tab_background_selected))
                }
                else {
                    isCatsBtnSelected = false
                    catsBtn.setCardBackgroundColor(ContextCompat.getColor(context, R.color.filter_btn_background))
                }
            }
        }
    }

    interface FilterButtonsHandler {
        fun setOnAllPetsClickListener()
        fun setOnDogsClickListener()
        fun setOnCatsClickListener()
    }
}