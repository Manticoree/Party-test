package com.git.party.ui.party.information

import com.git.party.data.entity.ItemPartyPage
import com.git.party.data.repository.PartyPageRepository
import kotlinx.coroutines.*

class InformationPresenter(
    private val view: InformationContract.View,
    partyPageRepository: PartyPageRepository = PartyPageRepository()
) :
    InformationContract.Presenter, CoroutineScope by MainScope() {

    init {
        launch(Dispatchers.IO) {
            val itemPartyPage = partyPageRepository.getDataFromJson()
            withContext(Dispatchers.Main) {
                onShowGuestList(itemPartyPage)
                onShowImageNameOwner(itemPartyPage)
                onShowTitleImage(itemPartyPage)
            }
        }
    }

    override fun onShowTitleImage(itemPartyPage: ItemPartyPage) {
        view.showTitleImage(itemPartyPage.imageTitleUrl, itemPartyPage.partyName)
    }

    override fun onShowImageNameOwner(itemPartyPage: ItemPartyPage) {
        view.showImageNameOwner(itemPartyPage.partyOwnerPhotoUrl, itemPartyPage.partyOwnerName)
    }

    override fun onShowGuestList(itemPartyPage: ItemPartyPage) {
        view.showGuestList(itemPartyPage.guestList)
    }

}