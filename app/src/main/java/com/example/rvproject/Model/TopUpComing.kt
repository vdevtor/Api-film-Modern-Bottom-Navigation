package com.example.rvproject.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TopUpComing(
    val dates: Dates,
    val page: Int,
    val results: List<ResultXX>,
    val total_pages: Int,
    val total_results: Int
):Parcelable