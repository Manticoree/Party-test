package com.git.party.base

import android.app.Application
import com.git.party.di.component.AppComponent
import com.git.party.di.component.DaggerAppComponent
import com.git.party.di.modules.ApplicationModule
import com.git.party.di.modules.ContextModule


class BaseApplication : Application() {

    companion object {
        lateinit var applicationComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerAppComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .contextModule(ContextModule(this))
            .build()
        applicationComponent.inject(this)
    }
}