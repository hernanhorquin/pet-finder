package com.example.petfinder.data.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pet(
    val petId: String,
    val userId: String,
    val name: String?,
    val description: String?,
    val size: String?,
    val gender: String?,
    val hairColor: String?,
    val age: String?,
    val lostDate: String?,
    val city: String?,
    val hood: String?,
    val breed: String?,
    val catOrDog: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }
}