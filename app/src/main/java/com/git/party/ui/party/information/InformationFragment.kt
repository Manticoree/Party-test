package com.git.party.ui.party.information

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.git.party.R
import com.git.party.adapter.GuestAdapter
import com.git.party.base.BaseFragment
import com.git.party.data.entity.ItemGuest
import com.google.android.material.imageview.ShapeableImageView
import kotlinx.android.synthetic.main.fragment_information.*

class InformationFragment : InformationContract.View, BaseFragment() {

    private lateinit var presenter: InformationContract.Presenter
    private lateinit var adapter: GuestAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_information, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = InformationPresenter(this)
        presenter.onShowTitleImage()
        presenter.onShowImageNameOwner()
        presenter.onShowGuestList()
    }

    override fun showTitleImage(titleImage: String, title: String) {
        activity?.let {
            loadImage(
                it,
                titleImage,
                sivTitleImage
            )
        }
        mtvTitleParty.text = title
    }

    override fun showImageNameOwner(ownerImage: String, ownerName: String) {
        activity?.let {
            loadCircleImage(
                it,
                ownerImage,
                sivOwnerPhoto
            )
        }
        mtvOwnerName.text = ownerName
    }

    override fun showGuestList(guestList: List<ItemGuest>) {
        rvGuestList.setHasFixedSize(true)
        val manager: RecyclerView.LayoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.VERTICAL,
            false
        )
        rvGuestList.layoutManager = manager
        adapter = GuestAdapter(guestList)
        rvGuestList.adapter = adapter
    }

    override fun loadCircleImage(context: Context, image: String, view: ShapeableImageView) {
        context.let {
            Glide.with(it)
                .load(image)
                .circleCrop()
                .into(view)
        }
    }

    override fun loadImage(context: Context, image: String, view: ImageView) {
        context.let {
            Glide.with(it)
                .load(image)
                .into(view)
        }
    }

}