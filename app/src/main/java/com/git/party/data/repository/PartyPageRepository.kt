package com.git.party.data.repository

import android.content.Context
import com.git.party.base.BaseApplication
import com.git.party.data.entity.ItemPartyPage
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.IOException
import java.io.InputStream
import javax.inject.Inject

class PartyPageRepository {

    @Inject
    lateinit var context: Context

    init {
        BaseApplication.applicationComponent.inject(this)
    }

    fun getDataFromJson(): ItemPartyPage {
        val builderPage = GsonBuilder()
        val gson: Gson = builderPage.create()
        return gson.fromJson(reader(), ItemPartyPage::class.java)
    }

    private fun reader(): String? {
        var jsonPartyPage: String
        return try {
            val inputPage: InputStream = context.assets.open("parties.json")
            val size: Int = inputPage.available()
            val buffer = ByteArray(size)
            inputPage.read(buffer)
            inputPage.close()
            jsonPartyPage = String(buffer)
            jsonPartyPage
        } catch (ex: IOException) {
            ex.printStackTrace()
            ""
        }
    }


}