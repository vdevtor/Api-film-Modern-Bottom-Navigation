package com.example.rvproject.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class TopRated(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
): Parcelable