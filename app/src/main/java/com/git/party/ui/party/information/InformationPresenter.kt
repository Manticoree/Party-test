package com.git.party.ui.party.information

import com.git.party.data.repository.PartyPageRepository

class InformationPresenter(private val view: InformationContract.View) :
    InformationContract.Presenter {

    private var partyPageRepository: PartyPageRepository = PartyPageRepository()

    override fun onShowTitleImage() {
        view.showTitleImage(
            partyPageRepository.getDataFromJson().imageTitleUrl,
            partyPageRepository.getDataFromJson().partyName
        )
    }

    override fun onShowImageNameOwner() {
        view.showImageNameOwner(
            partyPageRepository.getDataFromJson().partyOwnerPhotoUrl,
            partyPageRepository.getDataFromJson().partyOwnerName
        )
    }

    override fun onShowGuestList() {
        view.showGuestList(partyPageRepository.getDataFromJson().guestList)
    }

}