package com.git.party.di.component

import android.app.Application
import android.content.Context
import com.git.party.base.BaseApplication
import com.git.party.data.repository.PartyPageRepository
import com.git.party.di.ApplicationContext
import com.git.party.di.modules.ApplicationModule
import com.git.party.di.modules.ContextModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        ContextModule::class,
        ApplicationModule::class
    ]
)
interface AppComponent {

    @ApplicationContext
    fun context(): Context

    fun application(): Application

    fun inject(mainApplication: BaseApplication)

    fun inject(partyPageRepository: PartyPageRepository)
}