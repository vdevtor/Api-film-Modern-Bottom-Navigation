package com.example.rvproject.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResultX(
    val adult: Boolean,
    val id: Int,
    val known_for: List<KnownFor>,
    val name: String,
    val popularity: Double,
    var profile_path: String
): Parcelable