package com.git.party.ui.party.information

import android.content.Context
import com.git.party.data.entity.ItemGuest
import com.google.android.material.imageview.ShapeableImageView

interface InformationContract {

    interface View {
        fun showTitleImage(titleImage: String, title: String)
        fun showImageNameOwner(ownerImage: String, ownerName: String)
        fun showGuestList(guestList: List<ItemGuest>)
        fun loadImage(context: Context, image: String, view: ShapeableImageView)
    }

    interface Presenter {
        fun onShowTitleImage()
        fun onShowImageNameOwner()
        fun onShowGuestList()
    }
}