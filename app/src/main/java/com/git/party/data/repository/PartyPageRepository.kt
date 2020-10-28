package com.git.party.data.repository

import android.content.Context
import com.git.party.base.BaseApplication
import com.git.party.data.entity.ItemGuest
import com.git.party.data.entity.ItemPartyPage
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.IOException
import java.io.InputStream
import javax.inject.Inject

class PartyPageRepository {

    @Inject
    lateinit var context: Context
    private val builderPage = GsonBuilder()

    init {
        BaseApplication.applicationComponent.inject(this)
    }

    companion object {
        const val noData = "Нет данных"
    }

    fun getDataFromJson(): ItemPartyPage {
        val gson: Gson = builderPage.create()
        return if (reader() != noData) {
            gson.fromJson(reader(), ItemPartyPage::class.java)
        } else {
            errorDataFromJson()
        }
    }

    private fun reader(): String {
        val jsonPartyPage: String
        return try {
            val inputPage: InputStream = context.assets.open("parties.json")
            val size: Int = inputPage.available()
            val buffer = ByteArray(size)
            inputPage.read(buffer)
            inputPage.close()
            jsonPartyPage = String(buffer)
            jsonPartyPage
        } catch (e: IOException) {
            noData
        }
    }

    private fun errorDataFromJson(): ItemPartyPage {
        val itemGuest = ItemGuest(noData, "")
        val listItemGuest: MutableList<ItemGuest> = mutableListOf()
        listItemGuest.add(itemGuest)
        return ItemPartyPage(
            "",
            noData,
            noData,
            "",
            listItemGuest
        )
    }

}