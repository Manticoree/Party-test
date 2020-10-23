package com.git.party.data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemGuest(
    val guestName: String,
    val guestPhotoUrl: String
) : Parcelable