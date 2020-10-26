package com.git.party.ui.party.information

import com.git.party.data.repository.PartyPageRepository

class InformationPresenter(private val view: InformationContract.View) :
    InformationContract.Presenter {

    private var partyPageRepository: PartyPageRepository = PartyPageRepository()

    override fun onShowTitleImage() {
        view.showTitleImage(
            partyPageRepository.itemPartyPage.imageTitleUrl,
            partyPageRepository.itemPartyPage.partyName
        )
    }

    override fun onShowImageNameOwner() {
        view.showImageNameOwner(
            partyPageRepository.itemPartyPage.partyOwnerPhotoUrl,
            partyPageRepository.itemPartyPage.partyOwnerName
        )
    }

    override fun onShowGuestList() {
        view.showGuestList(partyPageRepository.itemPartyPage.guestList)
    }

}