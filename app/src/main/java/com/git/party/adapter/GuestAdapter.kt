package com.git.party.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.git.party.R
import com.git.party.data.entity.ItemGuest
import kotlinx.android.synthetic.main.item_guest.view.*

class GuestAdapter(private val listGuest: List<ItemGuest>) :
    RecyclerView.Adapter<GuestAdapter.GuestViewHolder>() {

    private lateinit var inflater: LayoutInflater

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {
        inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.item_guest, parent, false)
        return GuestViewHolder(view)
    }

    override fun getItemCount(): Int = listGuest.size

    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
        holder.bind(listGuest[position])
    }

    inner class GuestViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(
        itemView
    ) {
        fun bind(itemGuest: ItemGuest) {
            Glide.with(itemView)
                .load(itemGuest.guestPhotoUrl)
                .circleCrop()
                .into(itemView.sivGuestPhoto)
            itemView.mtvGuestName.text = itemGuest.guestName
        }
    }

}