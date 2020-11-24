package com.example.rvproject.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Dates(
    val maximum: String,
    val minimum: String
) :Parcelable