package com.example.submissionakhiraplikasiandroid

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Art(
    val title: String,
    val description: String,
    val photo: Int,
    val created: String,
    val location: String,
    val link: String
): Parcelable
