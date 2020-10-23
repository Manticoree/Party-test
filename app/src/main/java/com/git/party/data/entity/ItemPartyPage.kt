package com.git.party.data.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ItemPartyPage(
    val imageTitleUrl: String,
    val partyName: String,
    val partyOwnerName: String,
    val partyOwnerPhotoUrl: String,
    val guestList: List<ItemGuest>
) : Parcelable