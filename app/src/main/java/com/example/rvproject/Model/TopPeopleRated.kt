package com.example.rvproject.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TopPeopleRated(
    val page: Int,
    val results: List<ResultX>,
    val total_pages: Int,
    val total_results: Int
):Parcelable