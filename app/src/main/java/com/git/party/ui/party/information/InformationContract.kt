package com.git.party.ui.party.information

import android.content.Context
import android.widget.ImageView
import com.git.party.data.entity.ItemGuest
import com.git.party.data.entity.ItemPartyPage
import com.google.android.material.imageview.ShapeableImageView

interface InformationContract {

    interface View {
        fun showTitleImage(titleImage: String, title: String)
        fun showImageNameOwner(ownerImage: String, ownerName: String)
        fun showGuestList(guestList: List<ItemGuest>)
        fun loadCircleImage(context: Context, image: String, view: ShapeableImageView)
        fun loadImage(context: Context, image: String, view: ImageView)
    }

    interface Presenter {
        fun onShowTitleImage(itemPartyPage: ItemPartyPage)
        fun onShowImageNameOwner(itemPartyPage: ItemPartyPage)
        fun onShowGuestList(itemPartyPage: ItemPartyPage)
    }

}